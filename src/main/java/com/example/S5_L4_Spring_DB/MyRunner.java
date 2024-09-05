package com.example.S5_L4_Spring_DB;


import com.example.S5_L4_Spring_DB.entities.*;
import com.example.S5_L4_Spring_DB.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private Menu menu;
    @Autowired
    private Ordine ordine;
    @Autowired
    private ProdottoService prodottoService;

    @Autowired
    private Prodotto margherita;
    @Autowired
    private Prodotto hawaiian;
    @Autowired
    private Prodotto salami;

    @Autowired
    private Topping Cheese;
    @Autowired
    private Topping Tomato;
    @Autowired
    private Topping Ham;
    @Autowired
    private Topping Onions;
    @Autowired
    private Topping Pineapple;
    @Autowired
    private Topping Salami;

    @Autowired
    private Bevande Lemonade;
    @Autowired
    private Bevande Water;
    @Autowired
    private Bevande Wine;



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inizio Run");



//        prodottoService.saveProdotto(Cheese);
//        prodottoService.saveProdotto(Tomato);
//        prodottoService.saveProdotto(Ham);
//        prodottoService.saveProdotto(Onions);
//        prodottoService.saveProdotto(Pineapple);
//        prodottoService.saveProdotto(Salami);
//
//        prodottoService.saveProdotto(Lemonade);
//        prodottoService.saveProdotto(Water);
//        prodottoService.saveProdotto(Wine);
//
//        prodottoService.saveProdotto(margherita);
//        prodottoService.saveProdotto(hawaiian);
//        prodottoService.saveProdotto(salami);

        prodottoService.findAllProdotti().forEach(System.out::println);




//        menu.vediMenu();
//        System.out.println(ordine);


    }
}
