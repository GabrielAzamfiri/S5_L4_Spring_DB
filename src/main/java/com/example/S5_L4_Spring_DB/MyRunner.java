package com.example.S5_L4_Spring_DB;


import com.example.S5_L4_Spring_DB.entities.*;
import com.example.S5_L4_Spring_DB.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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

        System.out.println("***********findAllProdotti****************");
        List<Prodotto> listaProdotti = prodottoService.findAllProdotti();
        listaProdotti.forEach(System.out::println);

        System.out.println("***********findProdottoById****************");
        System.out.println(prodottoService.findProdottoById(UUID.fromString("137eb8c5-1f68-4dfe-ad16-8971c25dd063")));

        System.out.println("***********findByPrezzo****************");
        prodottoService.findByPrezzo(1.29).forEach(System.out::println);

        System.out.println("***********findByPartialName****************");
        prodottoService.findByPartialNome("Pi").forEach(System.out::println);


//        menu.vediMenu();
//        System.out.println(ordine);


    }
}
