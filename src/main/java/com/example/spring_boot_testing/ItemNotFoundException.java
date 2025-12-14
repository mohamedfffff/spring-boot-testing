package com.example.spring_boot_testing;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException{
    
    public ItemNotFoundException(String name) {
        super("Item with name " + name + "doesn't exist");
    }
}
