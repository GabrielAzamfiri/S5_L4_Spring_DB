package com.example.S5_L4_Spring_DB.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "prodotto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Prodotto {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE) // toglie il setter per l'id
    protected UUID id;

    @Column(name = "nome", nullable = false)
    protected String nome;

    @Column(name = "prezzo", nullable = false)
    protected Double prezzo;

    @Column(name = "calorie", nullable = false)
    protected Integer calorie;


    public Prodotto(String nome, Double prezzo, Integer calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }
}
