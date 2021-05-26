package com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import org.springframework.stereotype.Repository;

@Repository
public interface FCRepository extends JpaRepository<FitnessCentar, Long> {
}
