package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.Termin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminRepository extends JpaRepository<Termin, Long> {

    List<Termin> findAllById(Long id);
   /*
   public Termin findOneById(Long id);

    // naziv
    List<Termin> findAllByTreningNazivContaining(String naziv);

    // opis
    List<Termin> findAllByTreningOpisContaining(String opis);

    // tip treninga
    List<Termin> findAllByTreningTipTreninga(TipTreninga tipTreninga);

    // pocetak termina
    List<Termin> findAllByOrderByPocetakTermina();
    List<Termin> findAllByOrderByPocetakTerminaDesc();
    List<Termin> findAllByPocetakTerminaLessThan(Date pocetakTermina);
    List<Termin> findAllByPocetakTerminaGreaterThanEqual(Date pocetakTermina);

    // cena
    List<Termin> findAllByOrderByCena();
    List<Termin> findAllByOrderByCenaDesc();
    List<Termin> findAllByCenaGreaterThan(double cena);
    List<Termin> findAllByCenaLessThanEqual(double cena);
    */



}
