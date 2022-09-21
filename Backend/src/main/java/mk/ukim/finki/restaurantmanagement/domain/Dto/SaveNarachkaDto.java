package mk.ukim.finki.restaurantmanagement.domain.Dto;

import mk.ukim.finki.restaurantmanagement.domain.Narachka;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SaveNarachkaDto {
    public Long id;
    public int kolichina;
    public Long tableId;
}
