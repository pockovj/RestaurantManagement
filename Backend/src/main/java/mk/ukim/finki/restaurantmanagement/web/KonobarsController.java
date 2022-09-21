package mk.ukim.finki.restaurantmanagement.web;

import mk.ukim.finki.restaurantmanagement.domain.Konobar;
import mk.ukim.finki.restaurantmanagement.service.KonobarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/konobars")
public class KonobarsController {
    private final KonobarsService konobarsService;

    public KonobarsController(KonobarsService konobarsService) {
        this.konobarsService = konobarsService;
    }

    @GetMapping()
    public List<Konobar> getAllKonobars() {
        return konobarsService.findAllKonobars();
    }
}
