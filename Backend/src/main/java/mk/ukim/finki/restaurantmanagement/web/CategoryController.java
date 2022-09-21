package mk.ukim.finki.restaurantmanagement.web;

import lombok.AllArgsConstructor;
import mk.ukim.finki.restaurantmanagement.domain.Category;
import mk.ukim.finki.restaurantmanagement.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAllCategories();
    }
    @GetMapping("/{id}")
    public Category findCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }
}

