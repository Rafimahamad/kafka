package com.items.service;

import com.items.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void createItem(Item item);
   List<Item> getAllItems();

  Item updateItembyId(String id);

}
