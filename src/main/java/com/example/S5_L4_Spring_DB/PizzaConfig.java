package com.example.S5_L4_Spring_DB;



import com.example.S5_L4_Spring_DB.entities.*;
import com.example.S5_L4_Spring_DB.enums.StatoTavolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration // Annotazione OBBLIGATORIA se vogliamo che questa classe venga presa in considerazione all'avvio dell'applicazione
@PropertySource("application.properties")
public class PizzaConfig {

    @Bean
    public Topping Cheese(){
        return new Topping("Cheese", 0.69 , 92);
    }
    @Bean
    public Topping Tomato(){
        return new Topping("Tomato", 0.69 , 92);
    }

    @Bean
    public Topping Ham(){
        return new Topping("Ham", 0.99 , 35);
    }
    @Bean
    public Topping Onions(){
        return new Topping("Onions", 0.69 , 22);
    }
    @Bean
    public Topping Pineapple(){
        return new Topping("Pineapple", 0.79 , 24);
    }
    @Bean
    public Topping Salami(){
        return new Topping("Salami", 0.99 , 86);
    }


    @Bean
    public Bevande Lemonade(){
        return new Bevande("Lemonade", 1.29,128, 0.33);
    }

    @Bean
    public Bevande Water(){
        return new Bevande("Water", 1.29,0, 0.33);
    }

    @Bean
    public Bevande Wine(){
        return new Bevande("Wine", 7.49,607, 0.75);
    }


    @Bean
    @Scope("prototype") // Annotazione opzionale. Mi serve quando voglio che lo SCOPE NON SIA SINGLETON
    // SINGLETON = c'è un UNICA COPIA DELL'OGGETTO in tutta l'applicazione. Questo è il valore di default (ed è estremamente utile)
    // PROTOTYPE = ogni volta che uso .getBean() mi verrà restituito un nuovo oggetto scollegato dal precedente
    //@Primary // Annotazione per risolvere le ambiguità. Quando ci sarà il dubbio su quale Student scegliere, verrà scelto questo (una sorta di default)
    public Pizza margherita(){
       Pizza margherita = new Pizza("Pizza Margherita", 4.99,1104);
       margherita.addTopping(Tomato());
       margherita.addTopping(Cheese());

       return margherita;
    }

    @Bean
    public Pizza hawaiian(){
        Pizza hawaiian = margherita();
        hawaiian.setNome("Hawaiian Pizza");
        hawaiian.setPrezzo(6.49);
        hawaiian.setCalorie(1024);
        hawaiian.addTopping(Ham());
        hawaiian.addTopping(Pineapple());

        return hawaiian;
    }

    @Bean
    public Pizza salami(){
        Pizza salami = new Pizza("Salami Pizza", 5.99,1160);
        salami.addTopping(Tomato());
        salami.addTopping(Cheese());
        salami.addTopping(Salami());

        return salami;
    }

    @Bean
    public Menu menu(){
        Menu menu = new Menu();
        menu.addPizze(margherita());
        menu.addPizze(hawaiian());
        menu.addPizze(salami());

        menu.addTopping(Cheese());
        menu.addTopping(Tomato());
        menu.addTopping(Ham());
        menu.addTopping(Onions());
        menu.addTopping(Pineapple());
        menu.addTopping(Salami());

        menu.addDrink(Lemonade());
        menu.addDrink(Water());
        menu.addDrink(Wine());
       return menu;
    }


    @Bean
    public Double costoCoperto(@Value("${costo.coperto}") Double costoCoperto){
        return costoCoperto;
    }
    @Bean
    @Primary
    // Annotazione per risolvere le ambiguità. Quando ci sarà il dubbio su quale Student scegliere, verrà scelto questo (una sorta di default)
    public Tavolo tavolo1(){
        return new Tavolo(1,5, StatoTavolo.LIBERO);
    }

    @Bean
   // @Scope("prototype") // Annotazione opzionale. Mi serve quando voglio che lo SCOPE NON SIA SINGLETON
    // SINGLETON = c'è un UNICA COPIA DELL'OGGETTO in tutta l'applicazione. Questo è il valore di default (ed è estremamente utile)
    // PROTOTYPE = ogni volta che uso .getBean() mi verrà restituito un nuovo oggetto scollegato dal precedente
    public Tavolo tavolo2(){
        return new Tavolo(2,10, StatoTavolo.LIBERO);
    }

    @Bean
    @Primary
    public Ordine ordine1(@Value("${costo.coperto}") Double costoCoperto){
        Ordine ordine1 = new Ordine(1,5, tavolo1() , costoCoperto );
        ordine1.addProdotto(margherita());
        ordine1.addProdotto(Water());
        return ordine1;
    }
    @Bean
    public Ordine ordine2(@Value("${costo.coperto}") Double costoCoperto){
        Ordine ordine2 = new Ordine(2,7, tavolo2() , costoCoperto );
        ordine2.addProdotto(margherita());
        ordine2.addProdotto(salami());
        ordine2.addProdotto(Water());

        return ordine2;
    }
}
