package mk.ukim.finki.restaurantmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import mk.ukim.finki.restaurantmanagement.domain.Produkt;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class ProduktKolichina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produkt produkt;
    private int kolichina;

    public ProduktKolichina() {
    }

    public ProduktKolichina(Produkt produkt,int kolichina) {
        this.produkt = produkt;
        this.kolichina = kolichina;
    }
}
