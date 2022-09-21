package mk.ukim.finki.restaurantmanagement.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.DateTotal;
import mk.ukim.finki.restaurantmanagement.repository.DateTotalRepository;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DateTotalService {
    private final DateTotalRepository dateTotalRepository;
    public DateTotal findTotalForToday() {
        if(dateTotalRepository.findTotalForToday().isPresent()){
            return dateTotalRepository.findTotalForToday().get();
        }
        else
            return new DateTotal(LocalDate.now(),0L);
    }
    public void save(DateTotal dt) {
        dateTotalRepository.save(dt);
    }
}
