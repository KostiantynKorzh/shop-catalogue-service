package me.study.catalogue_service.service.admin;

import me.study.catalogue_service.model.Category;
import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.repository.CategoryRepository;
import me.study.catalogue_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AdminItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such item with id " + id));
    }

    public Item createNewItem(String title, Double price, String imagePath, List<Long> categoryIds) {
        return itemRepository.save(Item.builder()
                .title(title)
                .price(price)
                .imagePath(imagePath)
                .categories(formatCategoryIdsToCategories(categoryIds))
                .build());
    }

    public Item updateItem(Long id, String title, Double price, String imagePath, List<Long> categoryIds) {
        Item item = getItemById(id);
        if (title != null) {
            item.setTitle(title);
        }
        if (price != null) {
            item.setPrice(price);
        }
        if (imagePath != null) {
            item.setImagePath(imagePath);
        }
        if (categoryIds != null) {
            item.setCategories(formatCategoryIdsToCategories(categoryIds));
        }

        return itemRepository.save(item);
    }

    private List<Category> formatCategoryIdsToCategories(List<Long> ids) {
        List<Category> categories = new LinkedList<>();
        ids.forEach(id -> {
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No such category with id " + id));
            categories.add(category);
        });

        return categories;
    }

    public List<Item> getItemsForOrder(List<Long> ids) {
        return itemRepository.findAllByIdIn(ids);
    }


    public Item deleteItem(Long id) {
        Item item = getItemById(id);
        itemRepository.delete(item);
        return item;
    }
}
