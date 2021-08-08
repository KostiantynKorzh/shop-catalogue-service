package me.study.catalogue_service.controller.admin;

import me.study.catalogue_service.dto.request.NewItemRequest;
import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.service.admin.AdminItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin/items")
public class AdminItemController {

    @Autowired
    private AdminItemService adminItemService;

    @GetMapping
    public List<Item> getAllItems() {
        return adminItemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return adminItemService.getItemById(id);
    }

    @PostMapping
    public Item createNewItem(@RequestBody NewItemRequest newItem) {
        return adminItemService.createNewItem(newItem.title(), newItem.price(), newItem.imagePath(), newItem.categoryIds());
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody NewItemRequest newItem){
        return adminItemService.updateItem(id, newItem.title(), newItem.price(), newItem.imagePath(), newItem.categoryIds());
    }

    @DeleteMapping("/{id}")
    public Item deleteItem(@PathVariable Long id){
        return adminItemService.deleteItem(id);
    }

}
