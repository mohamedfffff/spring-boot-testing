package com.example.spring_boot_testing;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ItemAlreadyExistsException extends RuntimeException{
    
    public ItemAlreadyExistsException(String name){
        super("Item with name " + name + "already eixsts");
    }
}
