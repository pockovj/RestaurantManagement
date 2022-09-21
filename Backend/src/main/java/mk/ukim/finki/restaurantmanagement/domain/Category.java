package mk.ukim.finki.restaurantmanagement.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JsonManagedReference
    private List<Produkt> produkti;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }
}
