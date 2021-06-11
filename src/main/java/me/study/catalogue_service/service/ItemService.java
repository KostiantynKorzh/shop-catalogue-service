package me.study.catalogue_service.service;

import me.study.catalogue_service.dto.ItemDTO;
import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createNewItem(String title, Double price) {
        return itemRepository.save(Item.builder()
                .title(title)
                .price(price)
                .build());
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

}
