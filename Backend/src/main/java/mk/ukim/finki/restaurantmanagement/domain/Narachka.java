package mk.ukim.finki.restaurantmanagement.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Narachka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<ProduktKolichina> produktKolichina;

    public Narachka() {
    }

    public Narachka(List<ProduktKolichina> productKolichina) {
        this.produktKolichina = productKolichina;
    }
}
