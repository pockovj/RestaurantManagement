package mk.ukim.finki.restaurantmanagement.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class DateTotal {
    @Id
    private LocalDate date;
    private Long total;

    public DateTotal(LocalDate date, Long total) {
        this.date = date;
        this.total = total;
    }

    public DateTotal() {
    }
}
