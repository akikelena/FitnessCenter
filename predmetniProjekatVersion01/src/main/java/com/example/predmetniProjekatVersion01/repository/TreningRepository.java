package com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreningRepository extends JpaRepository<Trening, Long> {
/*
    void deleteById(Long id);

    // pretraga treninga u ponudi -> svih treninga, bez parametara za pretragu
    List<Trening> findAll();

    // pretraga treninga po POJEDINACNIM kriterijumima
    // 1. NAZIV
    List<Trening> findByNaziv(String naziv);

    // 2. OPIS
    List<Trening> findByOpis(String opis);

    // 3. TIP TRENINGA
    List<Trening> findByTipTreninga(TipTreninga tipTreninga);

    // 4. TRAJANJE
    List<Trening> findByTrajanje(int trajanje);

    // 5. CENA
    List<Trening> findByCena(int cena);

    // VISEKRITERIJUMSKA pretraga
    List<Trening> findByTipTreningaAndCena(TipTreninga tipTreninga, int cena);
    List<Trening> findTreningsByCenaIsLessThanAndTipTreningaOrderByCena(int cena, TipTreninga tipTreninga);
        */

}
