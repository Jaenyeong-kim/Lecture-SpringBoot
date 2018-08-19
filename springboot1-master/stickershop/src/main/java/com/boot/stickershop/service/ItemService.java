package com.boot.stickershop.service;

import com.boot.stickershop.domain.Item;

import java.util.List;

public interface ItemService {
    public Item getItem(Long id);
    public Item addItem(Item item);
    public List<Item> getItems();
}
