package mk.ukim.finki.restaurantmanagement.repository;

import mk.ukim.finki.restaurantmanagement.domain.Narachka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarachkasRepository extends JpaRepository<Narachka,Long> {
}
