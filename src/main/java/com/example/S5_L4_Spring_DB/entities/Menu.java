package com.example.S5_L4_Spring_DB.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Menu {
  private List<Prodotto> prodottiMenuPizze;
    private List<Prodotto> prodottiMenuTopping;
    private List<Prodotto> prodottiMenuDrink;


    public Menu() {
        this.prodottiMenuPizze = new ArrayList<>();
        this.prodottiMenuTopping = new ArrayList<>();
        this.prodottiMenuDrink = new ArrayList<>();

    }

    public void addPizze ( Prodotto prodotto){
        this.prodottiMenuPizze.add(prodotto);
    }
    public void addTopping ( Prodotto prodotto){
        this.prodottiMenuTopping.add(prodotto);
    }
    public void addDrink ( Prodotto prodotto){
        this.prodottiMenuDrink.add(prodotto);
    }

    public void vediMenu(){
        System.out.println("PIZZAS  /  Calorie  /  Price");
        prodottiMenuPizze.forEach(System.out::println);
        System.out.println("\n");

        System.out.println("TOPPINGS  /  Calorie  /  Price");
        prodottiMenuTopping.forEach(System.out::println);
        System.out.println("\n");

        System.out.println("DRINKS  /  Calorie  /  Price");
        prodottiMenuDrink.forEach(System.out::println);



    }
}
