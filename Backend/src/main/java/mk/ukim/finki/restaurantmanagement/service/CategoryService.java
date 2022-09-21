package mk.ukim.finki.restaurantmanagement.service;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.Category;
import mk.ukim.finki.restaurantmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
