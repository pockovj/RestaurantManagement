package mk.ukim.finki.restaurantmanagement.repository;

import mk.ukim.finki.restaurantmanagement.domain.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Produkt,Long> {
}
