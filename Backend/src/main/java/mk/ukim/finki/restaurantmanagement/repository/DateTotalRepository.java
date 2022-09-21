package mk.ukim.finki.restaurantmanagement.repository;

import mk.ukim.finki.restaurantmanagement.domain.DateTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface DateTotalRepository extends JpaRepository<DateTotal, Date> {
    @Query("select d from DateTotal d where d.date = CURRENT_DATE")
    Optional<DateTotal> findTotalForToday();
}
