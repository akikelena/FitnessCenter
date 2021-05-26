package com.example.predmetniProjekatVersion01.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Korisnik;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
