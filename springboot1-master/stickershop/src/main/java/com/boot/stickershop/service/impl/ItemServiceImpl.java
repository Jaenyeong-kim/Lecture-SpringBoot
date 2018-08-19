package com.boot.stickershop.service.impl;

import com.boot.stickershop.domain.Item;
import com.boot.stickershop.repository.ItemRepository;
import com.boot.stickershop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // Bean으로 등록 되어야 함
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public Item getItem(Long id) {
        return itemRepository.getOne(id);
    }

    @Override
    @Transactional
    public Item addItem(Item item) {
        item = itemRepository.save(item);
        return item;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
