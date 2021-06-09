package com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findAll();

    List<Termin> findAllByTreningNazivContaining(String naziv);

    List<Termin> findAllByTreningOpisContaining(String opis);
    List<Termin> findAllByTreningContaining(String opis);

    List<Termin> findAllByTreningTipTreninga(TipTreninga tipTreninga);
    List<Termin> findAllByTreningContaining(TipTreninga tipTreninga);

    List<Termin> findAllByOrderPocetakTermina();
    List<Termin> findAllByOrderPocetakTerminaAsc();
    List<Termin> findAllByOrderPocetakTerminaDesc();
    List<Termin> findAllByPocetakLessThan(Date pocetakTermina);
    List<Termin> findAllByPocetakGreaterThanEqual(Date pocetakTermina);

    List<Termin> findAllByOrderCena();
    List<Termin> findAllByOrderCenaAsc();
    List<Termin> findAllByOrderCenaDesc();
    List<Termin> findAllByCenaGreaterThan(double cena);
    List<Termin> findAllByCenaLessThanEqual(double cena);

    List<Termin> findAllByPocetakTerminaLessThan(Date pocetakTermina);
    List<Termin> findAllByPocetakTerminaGreaterThanEqual(Date pocetakTermina);

}
