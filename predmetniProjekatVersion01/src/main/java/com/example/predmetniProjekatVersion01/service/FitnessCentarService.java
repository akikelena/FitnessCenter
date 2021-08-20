package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;

import java.util.List;


public interface FitnessCentarService {

    // dodavanje
    public FitnessCentar saveOrCreate(FitnessCentar fitnessCentar) throws Exception;

    // brisanje
    void delete(Long id);

    // izmena
    public FitnessCentar izmeni(FitnessCentar fitnessCentar);

    // Pretrazivanje svih FC-a
    public List<FitnessCentar> findAll();


    FitnessCentar findOne(Long id);

    List<FitnessCentarDTO> findSpecCentre();
}
