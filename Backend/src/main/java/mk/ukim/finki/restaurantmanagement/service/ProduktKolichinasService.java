package mk.ukim.finki.restaurantmanagement.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.ProduktKolichina;
import mk.ukim.finki.restaurantmanagement.repository.ProduktKolichinasRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProduktKolichinasService {
    private final ProduktKolichinasRepository produktKolichinasRepository;
    public void save(ProduktKolichina produktKolichina) {
        produktKolichinasRepository.save(produktKolichina);
    }
}
