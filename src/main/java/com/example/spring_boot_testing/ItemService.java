package com.example.spring_boot_testing;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item saveNewItem(String name, double price) {
        Item newItem = new Item(name, price);
        return itemRepository.save(newItem);
        
    }

    public Item updateItem(String name, double price) {
        Optional<Item> item = itemRepository.findByName(name);
        if (item.isEmpty()) {
            throw new ItemNotFoundException(name);
        } else {
            Item newItem = item.get();
            newItem.setName(name);
            newItem.setPrice(price);
            return itemRepository.save(newItem);
        }
    }

    @Transactional
    public void deleteItem(String name) {
        Optional<Item> item = itemRepository.findByName(name);
        if (item.isEmpty()) {
            throw new ItemNotFoundException(name);
            
        }
        itemRepository.deleteByName(name);
    }

    public Optional<Item> getItem(String name) {
        Optional<Item> item = itemRepository.findByName(name);
        if (item.isEmpty()) {
            throw new ItemNotFoundException(name);
        } else {
            return item;
        }
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
