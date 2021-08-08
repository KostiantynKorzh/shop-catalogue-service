package me.study.catalogue_service.service.admin;

import me.study.catalogue_service.model.Category;
import me.study.catalogue_service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class AdminCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }


    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such category with id " + id));
    }

    public Category createNewCategory(String categoryName) {
        return categoryRepository.save(new Category(categoryName.toUpperCase(Locale.ROOT)));
    }

    public Category updateCategory(Long id, String categoryName) {
        Category category = getCategoryById(id);
        category.setName(categoryName.toUpperCase(Locale.ROOT));
        return categoryRepository.save(category);
    }

    public Category deleteCategory(Long id) {
        Category category = getCategoryById(id);
        categoryRepository.delete(category);
        return category;
    }
}
