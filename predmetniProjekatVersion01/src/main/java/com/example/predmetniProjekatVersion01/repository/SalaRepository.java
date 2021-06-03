package com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.predmetniProjekatVersion01.entity.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
}
