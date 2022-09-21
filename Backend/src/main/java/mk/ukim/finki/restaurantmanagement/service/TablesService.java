package mk.ukim.finki.restaurantmanagement.service;
import mk.ukim.finki.restaurantmanagement.domain.Masa;
import mk.ukim.finki.restaurantmanagement.repository.TablesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TablesService {
    private final TablesRepository tablesRepository;

    public TablesService(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }
    public List<Masa> findAllTables() {
        return tablesRepository.findAll();
    }
    public Masa findById(Long id) {
        return this.tablesRepository.findById(id).orElse(null);
    }
    public void save(Masa table) {
        this.tablesRepository.save(table);
    }
}
