package me.study.catalogue_service.controller;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.mapper.ItemMapper;
import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItems() throws InterruptedException {
        Thread.sleep(2000);
//        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        return ResponseEntity.ok(ItemMapper.INSTANCE.map(itemService.getAllItems()));
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
