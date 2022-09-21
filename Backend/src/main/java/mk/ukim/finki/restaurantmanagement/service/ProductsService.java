package mk.ukim.finki.restaurantmanagement.service;

import mk.ukim.finki.restaurantmanagement.domain.Produkt;
import mk.ukim.finki.restaurantmanagement.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    public List<Produkt> findAllProducts() {
        return productsRepository.findAll();
    }
    public Produkt findProductById(Long id) { return productsRepository.findById(id).get();}
}
