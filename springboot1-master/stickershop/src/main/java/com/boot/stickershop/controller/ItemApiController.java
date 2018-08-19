package com.boot.stickershop.controller;

import com.boot.stickershop.domain.Item;
import com.boot.stickershop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemApiController {
    @Autowired
    ItemService itemService;

    @GetMapping
    public List<Item> items() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable(name = "id") Long id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item save() {
        Item item = new Item();
        item.setName("kimchi");
        item.setPrice(5000);
        item = itemService.addItem(item);
        return item;
    }
}
