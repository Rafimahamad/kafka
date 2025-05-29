package com.items.service.impl;

import com.items.entity.Item;
import com.items.repositories.ItemRepo;
import com.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceimpl implements ItemService {
    @Autowired
    private ItemRepo repo;

    @Override
    public void createItem(Item item) {
       this.repo.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = this.repo.findAll();
        return itemList;
    }

    @Override
    public Item updateItembyId(String id) {
        
        return null;
    }
}
