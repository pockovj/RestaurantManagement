package mk.ukim.finki.restaurantmanagement.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.Produkt;
import mk.ukim.finki.restaurantmanagement.service.ProductsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    @GetMapping("/{id}")
    public Produkt getProductById(@PathVariable Long id) {
        return productsService.findProductById(id);
    }
}
