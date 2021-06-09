package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.repository.FCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessCentarService {

    @Autowired
    private FCRepository fcRepository;

    /*
        FUNKCIONALNOSTI - ADMIN
     */

    // dodavanje
    public FitnessCentar save(FitnessCentar fitnessCentar) throws Exception{
        if(fitnessCentar.getId() != null) {
            throw new Exception("ID mora biti null vrednost!");
        }
        FitnessCentar fitnessCentar1 = this.fcRepository.save(fitnessCentar);
        return  fitnessCentar1;
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

    // Pretrazivanje svih FC-a
    public List<FitnessCentar> pretrazi_sve(){
        List<FitnessCentar> fitnessCentarList = this.fcRepository.findAll();
        return fitnessCentarList;
    }

    // Pretraga specificnog FC-a
    public FitnessCentar pronadji(Long id){
        FitnessCentar fitnessCentar = this.fcRepository.findById(id);
        return fitnessCentar;
    }

}
