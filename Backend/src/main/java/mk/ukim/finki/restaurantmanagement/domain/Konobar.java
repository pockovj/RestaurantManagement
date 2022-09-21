package mk.ukim.finki.restaurantmanagement.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Konobar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String password;
    private boolean superuser;

    public Konobar() {
    }

    public Konobar(String ime, String password, boolean superuser) {
        this.ime = ime;
        this.password = password;
        this.superuser = superuser;
    }
}
