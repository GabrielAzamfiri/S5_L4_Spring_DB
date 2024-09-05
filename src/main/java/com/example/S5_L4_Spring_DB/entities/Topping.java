package com.example.S5_L4_Spring_DB.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topping")
@Getter
@Setter
public class Topping extends Prodotto{

    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> listaPizze = new ArrayList<>();

    public Topping(){}

    public Topping(String nome, Double prezzo, Integer calorie) {
        super(nome, prezzo, calorie);
    }

    @Override
    public String toString() {
        return  nome + "  /  " +   prezzo + "  /  " +  calorie ;
    }
}
