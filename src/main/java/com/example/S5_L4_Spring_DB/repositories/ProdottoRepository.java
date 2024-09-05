package com.example.S5_L4_Spring_DB.repositories;

import com.example.S5_L4_Spring_DB.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Specializzazione di @Component dedicata al mondo dei DB
public interface ProdottoRepository  extends JpaRepository<Prodotto, UUID> {
}
