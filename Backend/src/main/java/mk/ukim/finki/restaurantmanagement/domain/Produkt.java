package mk.ukim.finki.restaurantmanagement.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Produkt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private Long cena;
    private int stock;
    @ManyToOne
    @JsonBackReference
    private Category kategorija;
    public Produkt() {
    }

    public Produkt(String ime, Long cena, int stock) {
        this.ime = ime;
        this.cena = cena;
        this.stock = stock;
    }
}
