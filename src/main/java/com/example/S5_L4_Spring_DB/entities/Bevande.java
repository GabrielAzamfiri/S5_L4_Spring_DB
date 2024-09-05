package com.example.S5_L4_Spring_DB.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "bevande")
@Getter
@Setter
@NoArgsConstructor
public class Bevande extends Prodotto {
    @Column(name = "litri")
    private Double litri;



    public Bevande(String nome, Double prezzo, Integer calorie, Double litri) {
        super(nome, prezzo, calorie);
        this.litri = litri;
    }

    @Override
    public String toString() {
        return
              nome + "(" + litri + "l)  /  "  + calorie + "  /  " + prezzo ;
    }
}
