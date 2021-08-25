package me.study.catalogue_service.service;

import me.study.catalogue_service.model.Item;
import me.study.catalogue_service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No such item"));
    }

    public List<Item> getItemsForOrder(List<Long> ids){
        return itemRepository.findAllByIdIn(ids);
    }

}
