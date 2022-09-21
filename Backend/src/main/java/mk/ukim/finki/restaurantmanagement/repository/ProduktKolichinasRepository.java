package mk.ukim.finki.restaurantmanagement.repository;

import mk.ukim.finki.restaurantmanagement.domain.ProduktKolichina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktKolichinasRepository extends JpaRepository<ProduktKolichina,Long> {
}
