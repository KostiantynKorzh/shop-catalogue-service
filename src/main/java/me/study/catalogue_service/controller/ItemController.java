package me.study.catalogue_service.controller;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.dto.request.NewItemRequest;
import me.study.catalogue_service.mapper.ItemMapper;
import me.study.catalogue_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ItemDTO createNewItem(@RequestBody NewItemRequest newItem) {
        return ItemMapper.INSTANCE.toDTO(itemService.createNewItem(newItem.title(), newItem.price()));
    }

    @GetMapping
    public List<ItemDTO> getAllItems(){
        return ItemMapper.INSTANCE.map(itemService.getAllItems());
    }

}
