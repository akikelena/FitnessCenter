package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    List<Korisnik> findByImeOrPrezime(String ime, String prezime);
    List<Korisnik> findByKorisnickoImeIgnoreCase(String korisnickoIme);
    List<Korisnik> findByUlogaOrderByIme(Uloga uloga, String ime);
    List<Korisnik> findAllByImeAndUloga(Uloga uloga, String ime);
}
