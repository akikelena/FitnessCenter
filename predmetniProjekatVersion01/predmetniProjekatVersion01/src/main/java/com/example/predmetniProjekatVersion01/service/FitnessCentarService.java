package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.repository.FCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnessCentarService {

    @Autowired
    private FCRepository fcRepository;

    public FitnessCentar save(FitnessCentar fitnessCentar){
        return  this.fcRepository.save(fitnessCentar);
    }
    public void delete(Long id){
        this.fcRepository.deleteById(id);
    }
}
