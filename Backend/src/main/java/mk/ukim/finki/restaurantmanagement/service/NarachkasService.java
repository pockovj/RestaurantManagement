package mk.ukim.finki.restaurantmanagement.service;

import mk.ukim.finki.restaurantmanagement.domain.Narachka;
import mk.ukim.finki.restaurantmanagement.repository.NarachkasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NarachkasService {
    private final NarachkasRepository narachkasRepository;

    public NarachkasService(NarachkasRepository narachkasRepository) {
        this.narachkasRepository = narachkasRepository;
    }
    public List<Narachka> findAllNarachkas() {
        return narachkasRepository.findAll();
    }
    public void save(Narachka n) {
        narachkasRepository.save(n);
    }
}
