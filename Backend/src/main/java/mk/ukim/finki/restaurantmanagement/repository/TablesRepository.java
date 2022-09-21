package mk.ukim.finki.restaurantmanagement.repository;

import mk.ukim.finki.restaurantmanagement.domain.Masa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepository extends JpaRepository<Masa,Long> {
}
