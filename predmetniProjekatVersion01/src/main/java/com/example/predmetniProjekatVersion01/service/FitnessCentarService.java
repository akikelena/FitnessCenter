package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.repository.FCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FitnessCentarService {

    @Autowired
    private FCRepository fcRepository;

    /*
        FUNKCIONALNOSTI - ADMIN
     */

    // dodavanje
    public FitnessCentar save(FitnessCentar fitnessCentar){
        return  this.fcRepository.save(fitnessCentar);
    }

    // brisanje
    public void delete(Long id){
        this.fcRepository.deleteById(id);
    }

    // izmena
    public FitnessCentar izmeni(FitnessCentar fitnessCentar){
        return this.fcRepository.save(fitnessCentar);
    }

     /*
        FUNKCIONALNOSTI - CLANOVI + KORISNICI
     */

    // pretrazivanje FC
    public List<FitnessCentar> pretrazi_sve(){
        return fcRepository.findAll();
    }

    // pretraga specificnog FC-a
    public Optional<FitnessCentar> pronadji(Long id){
        return fcRepository.findById(id);
    }

}
