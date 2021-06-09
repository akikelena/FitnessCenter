package com.example.predmetniProjekatVersion01.repository;

import com.example.predmetniProjekatVersion01.entity.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreningRepository extends JpaRepository<Trening, Long> {


}
