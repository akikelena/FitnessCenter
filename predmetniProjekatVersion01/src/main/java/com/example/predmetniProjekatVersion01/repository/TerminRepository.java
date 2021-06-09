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

    List<Termin> findAllByTreninziNazivContaining(String naziv);

    List<Termin> findAllByTreninziOpisContaining(String opis);
    List<Termin> findAllByTreninziContaining(String opis);

    List<Termin> findAllByTreninziTipTreninga(TipTreninga tipTreninga);
    List<Termin> findAllByTreninziContaining(TipTreninga tipTreninga);

    List<Termin> findAllByOrderByPocetakTermina();
    List<Termin> findAllByOrderByPocetakTerminaAsc();
    List<Termin> findAllByOrderByPocetakTerminaDesc();
    List<Termin> findAllByPocetakTerminaLessThan(Date pocetakTermina);
    List<Termin> findAllByPocetakTerminaGreaterThanEqual(Date pocetakTermina);

    List<Termin> findAllByOrderByCena();
    List<Termin> findAllByOrderByCenaAsc();
    List<Termin> findAllByOrderByCenaDesc();
    List<Termin> findAllByCenaGreaterThan(double cena);
    List<Termin> findAllByCenaLessThanEqual(double cena);


}
