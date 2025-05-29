package com.items.controller;


import com.items.entity.ApiResponse;
import com.items.entity.Item;
import com.items.service.ItemService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ApiResponse> createItem(@RequestBody Item item, HttpServletRequest request) {

        String id = UUID.randomUUID().toString();
        item.setId(id);
        this.itemService.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(200, "item created! ", "Success", request.getRequestURI()));

    }

    @GetMapping("/get")
    public ResponseEntity<List<Item>> getAllItems(){

        List<Item> allItems = this.itemService.getAllItems();
        return ResponseEntity.ok(allItems);
    }

    @PutMapping
    public ResponseEntity<Item> updateitem(@PathVariable String id ){

        Item item=this.itemService.updateItembyId(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(item);
    }

}
