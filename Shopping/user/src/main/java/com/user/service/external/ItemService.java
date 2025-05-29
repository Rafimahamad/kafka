package com.user.service.external;

import com.user.entity.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ITEM-SERVICE")
public interface ItemService {

    @GetMapping("/item/get")
    List<Item> getAllItems();
}
