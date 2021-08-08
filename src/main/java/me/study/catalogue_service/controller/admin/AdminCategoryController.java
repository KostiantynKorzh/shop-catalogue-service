package me.study.catalogue_service.controller.admin;

import com.fasterxml.jackson.databind.JsonNode;
import me.study.catalogue_service.model.Category;
import me.study.catalogue_service.service.admin.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    
    @Autowired
    private AdminCategoryService adminCategoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return adminCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return adminCategoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createNewCategory(@RequestBody JsonNode request) {
        return adminCategoryService.createNewCategory(request.get("categoryName").textValue());
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody JsonNode request){
        return adminCategoryService.updateCategory(id, request.get("categoryName").textValue());
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable Long id){
        return adminCategoryService.deleteCategory(id);
    }
    
}
