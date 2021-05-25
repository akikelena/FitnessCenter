package main.java.com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
