package mk.ukim.finki.restaurantmanagement.domain.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import mk.ukim.finki.restaurantmanagement.domain.Narachka;

import java.util.List;

public class FiskalnaResponseDto {
    @JsonIgnore
    public List<Narachka> narachki;
    public Long total;

    public FiskalnaResponseDto(List<Narachka> narachki, Long total) {
        this.narachki = narachki;
        this.total = total;
    }
}
