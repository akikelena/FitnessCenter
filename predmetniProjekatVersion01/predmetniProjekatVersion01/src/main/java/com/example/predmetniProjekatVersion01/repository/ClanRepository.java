package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Clan;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanRepository extends  KorisnikRepository {
}
