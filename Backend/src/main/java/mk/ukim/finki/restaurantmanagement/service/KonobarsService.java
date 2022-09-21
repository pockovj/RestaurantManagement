package mk.ukim.finki.restaurantmanagement.service;

import mk.ukim.finki.restaurantmanagement.domain.Konobar;
import mk.ukim.finki.restaurantmanagement.repository.KonobarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KonobarsService {
    private final KonobarsRepository konobarsRepository;

    public KonobarsService(KonobarsRepository konobarsRepository) {
        this.konobarsRepository = konobarsRepository;
    }

    public List<Konobar> findAllKonobars() {
        return konobarsRepository.findAll();
    }
}
