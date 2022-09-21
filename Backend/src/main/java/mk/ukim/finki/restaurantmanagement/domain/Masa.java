package mk.ukim.finki.restaurantmanagement.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Masa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Narachka> narachki;
    private String ime;
    private Long totalPrice;

    public Masa() {
    }

    public Masa(String ime, Long totalPrice) {
        this.ime = ime;
        this.totalPrice = totalPrice;
        narachki = new ArrayList<>();
    }
}
