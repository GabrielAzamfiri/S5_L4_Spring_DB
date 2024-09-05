package com.example.S5_L4_Spring_DB.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id){
        super("Il record con id " + id + " non è stato trovato!");
    }
}