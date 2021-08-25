package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;

import java.util.List;


public interface FitnessCentarService {


     FitnessCentar saveOrCreate(FitnessCentar fitnessCentar) throws Exception;
     void delete(Long id);
     FitnessCentar izmeni(Long id, FitnessCentarDTO fitnessCentar) throws Exception;
     List<FitnessCentar> findAll();
     FitnessCentar findOne(Long id);
     List<FitnessCentarDTO> findSpecCentre();
}
