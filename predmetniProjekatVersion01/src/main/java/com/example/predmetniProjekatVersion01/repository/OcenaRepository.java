package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena, Long> {

}
