package com.example.S5_L4_Spring_DB.entities;



import com.example.S5_L4_Spring_DB.enums.StatoOrdine;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@PropertySource("application.properties")
@Getter
@Setter
@ToString
public class Ordine {

    private Integer nrOrdine;
    private List<Prodotto> prodottiOrdinati;
    private StatoOrdine stato;
    private Integer nrCoperti;
    private LocalDateTime oraAcquisizione;
    private Tavolo tavolo;
    private Double costoCoperto;
    private Double totale;

    public Ordine(Integer nrOrdine, Integer nrCoperti, Tavolo tavolo, Double costoCoperto) {
        this.nrOrdine = nrOrdine;
        this.stato = StatoOrdine.IN_CORSO;
        this.prodottiOrdinati = new ArrayList<>();
        this.nrCoperti = nrCoperti;
        this.oraAcquisizione = LocalDateTime.now();
        this.tavolo = tavolo;
        this.costoCoperto = costoCoperto;
        this.totale = costoCoperto * nrCoperti;
    }

    public void addProdotto ( Prodotto prodotto){
        this.prodottiOrdinati.add(prodotto);
        this.setTotale(this.totale + prodotto.prezzo);
    }

}
