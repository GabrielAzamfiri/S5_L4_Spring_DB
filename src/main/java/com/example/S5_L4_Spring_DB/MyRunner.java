package com.example.S5_L4_Spring_DB;


import com.example.S5_L4_Spring_DB.entities.Menu;
import com.example.S5_L4_Spring_DB.entities.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
@Autowired
private Menu menu;
@Autowired
private Ordine ordine;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inizio Run");

        menu.vediMenu();

        System.out.println(ordine);


    }
}
