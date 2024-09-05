package com.example.S5_L4_Spring_DB.services;


import com.example.S5_L4_Spring_DB.entities.Prodotto;
import com.example.S5_L4_Spring_DB.exceptions.NotFoundException;
import com.example.S5_L4_Spring_DB.repositories.ProdottoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service // Service è un'altra specializzazione di @Component
// Il service è una classe che ci consente di poter aggiungere ulteriore logica personalizzata durante le varie interazioni col database.
// Ad esempio quando salvo un nuovo record, prima di salvarlo posso effettuare tutta una serie di controlli di validazione dei suoi attributi
// oppure potrei magari aggiungere ulteriori attributi
@Slf4j
public class ProdottoService {
    @Autowired
    private ProdottoRepository prodottoRepository;


    public void saveProdotto(Prodotto prodotto){
        prodottoRepository.save(prodotto);
        log.info("Prodotto " + prodotto.getNome() + " salvato con successo!");
    }

    public List<Prodotto> findAllProdotti(){
        return prodottoRepository.findAll();
    }

    public Prodotto findProdottoById(UUID prodottoId){

        return prodottoRepository.findById(prodottoId).orElseThrow(() -> new NotFoundException(prodottoId)); // Alternativa molto più compatta al codice di sopra
    }

    public void findByIdAndDelete(UUID userId){
        Prodotto found = this.findProdottoById(userId);
        prodottoRepository.delete(found);
        log.info("Prodotto con id " + userId + " cancellato correttamente!");
    }

    public void findByIdAndUpdate(UUID prodottoId, Prodotto updatedProdotto){

        Prodotto found = this.findProdottoById(prodottoId);

        found.setNome(updatedProdotto.getNome());
        found.setCalorie(updatedProdotto.getCalorie());
        found.setPrezzo(updatedProdotto.getPrezzo());

        prodottoRepository.save(found);

        log.info("Prodotto con id " + prodottoId + " modificato correttamente!");
    }

    public List<Prodotto> findByPrezzo(Double prezzo){
        return prodottoRepository.findByPrezzo(prezzo);
    }

    public List<Prodotto> findByPartialNome(String partialName){
        return prodottoRepository.findByNomeStartingWith(partialName);
    }

}
