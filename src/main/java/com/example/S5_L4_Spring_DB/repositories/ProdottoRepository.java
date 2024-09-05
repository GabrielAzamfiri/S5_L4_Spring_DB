package com.example.S5_L4_Spring_DB.repositories;

import com.example.S5_L4_Spring_DB.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository // Specializzazione di @Component dedicata al mondo dei DB
public interface ProdottoRepository  extends JpaRepository<Prodotto, UUID> {

    List<Prodotto> findByPrezzo( Double prezzo);


    //controllare che le parole siano giuste findBy Nome(perche l'argometno è salvato come nome) StartingWith
    List<Prodotto> findByNomeStartingWith(String partialName);
    // SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT(:partialName, '%'))
}
