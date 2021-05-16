package com.mlts.store.Exception;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class BadRequestException extends Exception{
    private HashMap<String, String> errors;

    public BadRequestException(String message, HashMap<String, String> errors){
        super(message);
        this.errors = errors;
    }
}
