package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import com.example.predmetniProjekatVersion01.entity.Trening;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {

    List<Trening> findByNaziv(String naziv);
    List<Trening> findByTipTreninga(TipTreninga tipTreninga);
    List<Trening> findByOpisOrderByNaziv(String naziv, String opis);

}
