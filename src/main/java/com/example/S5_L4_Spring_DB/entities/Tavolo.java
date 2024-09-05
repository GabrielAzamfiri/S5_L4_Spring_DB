package com.example.S5_L4_Spring_DB.entities;



import com.example.S5_L4_Spring_DB.enums.StatoTavolo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.PropertySource;

//@PropertySource("application.properties")

@Getter
@Setter
@ToString
public class Tavolo {

    private Integer nrTavolo;
    private  Integer nrCopertiMax;
    private StatoTavolo stato;

    public Tavolo(Integer nrTavolo, Integer nrCopertiMax, StatoTavolo stato) {
        this.nrTavolo = nrTavolo;
        this.nrCopertiMax = nrCopertiMax;
        this.stato = stato;
    }

}
