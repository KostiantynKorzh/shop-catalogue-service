package me.study.catalogue_service.controller;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.dto.request.NewItemRequest;
import me.study.catalogue_service.mapper.ItemMapper;
import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ItemDTO createNewItem(@RequestBody NewItemRequest newItem) {
        return ItemMapper.INSTANCE.toDTO(itemService.createNewItem(newItem.title(), newItem.price(), newItem.imagePath()));
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return ItemMapper.INSTANCE.map(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ItemDTO getItem(@PathVariable Long id) {
        return ItemMapper.INSTANCE.toDTO(itemService.getItem(id));
    }

    @GetMapping("/orders")
    public List<Item> getItemsForOrder(@Param("ids") Long[] ids) {
        List<Long> listOfIds = Arrays.asList(ids);
        return itemService.getItemsForOrder(listOfIds);
    }

}
