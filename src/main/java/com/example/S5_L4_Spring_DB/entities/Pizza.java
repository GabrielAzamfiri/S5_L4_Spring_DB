package com.example.S5_L4_Spring_DB.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
public class Pizza extends Prodotto{
   @ManyToMany(fetch = FetchType.EAGER) // FetchType.EAGER quando uso many to many l'info del topping sta in una junction table e non nella tabella stessa di pizza
   // con FetchType.EAGER faccio si che la pizza e i topping siano collegati posso fare tranquillamente un toString di entrambe
   @JoinTable(name = "toppings", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String nome, Double prezzo, Integer calorie) {
        super(nome, prezzo, calorie);

    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }



    @Override
    public String toString() {
        String toppingList = toppings.isEmpty() ? "" : " (" + toppings.stream().map(topping -> topping.nome).collect(Collectors.joining(", ")) + ")";
        return
                nome + toppingList +"  /  "+ calorie  +"  /  " + prezzo;
    }
}
