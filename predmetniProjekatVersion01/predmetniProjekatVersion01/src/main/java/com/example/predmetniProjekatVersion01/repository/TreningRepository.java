package com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreningRepository extends JpaRepository<Trening, Long> {

    void deleteById(Long id);

    // pretraga treninga u ponudi -> svih treninga, bez parametara za pretragu
    List<Trening> findAll();

    // pretraga treninga po POJEDINACNIM kriterijumima
    List<Trening> findByNaziv(String naziv);

    List<Trening> findByOpis(String opis);

    List<Trening> findByTipTreninga(TipTreninga tipTreninga);

    List<Trening> findByTrajanje(int trajanje);

}
