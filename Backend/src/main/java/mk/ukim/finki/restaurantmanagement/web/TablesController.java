package mk.ukim.finki.restaurantmanagement.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.*;
import mk.ukim.finki.restaurantmanagement.domain.Dto.FiskalnaDto;
import mk.ukim.finki.restaurantmanagement.domain.Dto.FiskalnaResponseDto;
import mk.ukim.finki.restaurantmanagement.domain.Dto.SaveNarachkaDto;
import mk.ukim.finki.restaurantmanagement.service.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tables")
@AllArgsConstructor
public class TablesController {
    private final TablesService tablesService;
    private final ProductsService productsService;
    private final ProduktKolichinasService produktKolichinasService;
    private final NarachkasService narachkasService;
    private final DateTotalService dateTotalService;

    @GetMapping()
    public List<Masa> findAllTables() {
        return tablesService.findAllTables();
    }
    @GetMapping("/izveshtaj")
    public Long izveshtaj() {
        return dateTotalService.findTotalForToday().getTotal();
    }
    @GetMapping("/{id}")
    public Masa findTableById(@PathVariable Long id) {
        return tablesService.findById(id);
    }
    @PostMapping("/fiskalna")
    public FiskalnaResponseDto izvadiFiskalna(@RequestBody FiskalnaDto fiskalnaDto) {
        Masa table = tablesService.findById(fiskalnaDto.tableId);
        List<Narachka> narachki = table.getNarachki();
        Long total = table.getTotalPrice();
        DateTotal today = dateTotalService.findTotalForToday();
        today.setTotal(today.getTotal()+total);
        dateTotalService.save(today);
        FiskalnaResponseDto fiskalnaResponseDto = new FiskalnaResponseDto(narachki,total);
        //ISPRATI DO FISKALEN APARAT, VO SLUCAJOV VRAKJAME NA FRONTEND (poradi nedostatok na fiskalen aparat)
        table.setNarachki(new ArrayList<>());
        table.setTotalPrice(0L);
        tablesService.save(table);
        return fiskalnaResponseDto;
    }
    @PostMapping("/save")
    public boolean saveTable(@RequestBody SaveNarachkaDto saveNarachkaDto) {
        Boolean found =false;
        Produkt produkt = productsService.findProductById(saveNarachkaDto.id);
        if(produkt.getStock() >= saveNarachkaDto.kolichina) {
            produkt.setStock(produkt.getStock() - saveNarachkaDto.kolichina);
            Masa table = tablesService.findById(saveNarachkaDto.tableId);
            List<ProduktKolichina> pks = table.getNarachki().stream().flatMap(data -> data.getProduktKolichina().stream()).toList();
            for (int i = 0; i < pks.size(); i++) {
                if (pks.get(i).getProdukt() == produkt) {
                    found = true;
                    pks.get(i).setKolichina(pks.get(i).getKolichina() + saveNarachkaDto.kolichina);
                    produktKolichinasService.save(pks.get(i));
                }
            }
            if (!found) {
                ProduktKolichina pk = new ProduktKolichina(produkt, saveNarachkaDto.kolichina);
                produktKolichinasService.save(pk);
                Narachka narachka = new Narachka(List.of(pk));
                narachkasService.save(narachka);
                List<Narachka> narachki = table.getNarachki();
                narachki.add(narachka);
            }
            table.setTotalPrice(table.getTotalPrice() + (produkt.getCena() * saveNarachkaDto.kolichina));
            tablesService.save(table);
            return true;
        }
        else {
            return false;
        }
    }
}
