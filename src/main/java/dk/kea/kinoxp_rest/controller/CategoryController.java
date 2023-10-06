package dk.kea.kinoxp_rest.controller;

import dk.kea.kinoxp_rest.model.Category;
import dk.kea.kinoxp_rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping("/category")
    public ResponseEntity getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
