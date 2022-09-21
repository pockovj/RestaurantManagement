package mk.ukim.finki.restaurantmanagement.domain.initializer;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.*;
import mk.ukim.finki.restaurantmanagement.domain.ProduktKolichina;
import mk.ukim.finki.restaurantmanagement.repository.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final KonobarsRepository konobarsRepository;
    private final NarachkasRepository narachkasRepository;
    private final ProductsRepository productsRepository;
    private final TablesRepository tablesRepository;
    private final CategoryRepository categoryRepository;
    private final ProduktKolichinasRepository produktKolichinasRepository;

    @PostConstruct
    private void populate() {
        List<ProduktKolichina> productKolichinas = new ArrayList<>();
        Masa masa = null;
        long total = 0L;
        for(int i=1;i<=10;i++) {
            Konobar k = new Konobar("Konobar " + i,"konobar"+i,i%2==0);
            masa = new Masa(i+"",0L);
            Produkt produkt = new Produkt("Produkt " + i,i+250L,i+23);
            ProduktKolichina pk = new ProduktKolichina(produkt,i+1);
            total+= produkt.getCena()*pk.getKolichina();
            productKolichinas.add(pk);
            Category category = new Category("Category " + i);
            category.setProdukti(List.of(produkt));
            konobarsRepository.save(k);
            tablesRepository.save(masa);
            productsRepository.save(produkt);
            categoryRepository.save(category);
            produktKolichinasRepository.save(pk);
        }
        Narachka narachka = new Narachka(productKolichinas);
        masa.setNarachki(List.of(narachka));
        masa.setTotalPrice(total);
        narachkasRepository.save(narachka);
        tablesRepository.save(masa);
    }
}
