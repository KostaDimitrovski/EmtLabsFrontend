package mk.finki.ukim.emtlabs.controller;

import mk.finki.ukim.emtlabs.model.enums.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    @GetMapping("/list")
    public List<Category> findAllCategories()
    {
        return Arrays.asList(Category.values());
    }

}
