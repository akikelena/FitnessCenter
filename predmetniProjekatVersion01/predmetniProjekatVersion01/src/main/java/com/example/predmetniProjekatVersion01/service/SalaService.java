package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    // cuvanje
    public Sala save(Sala sala){
        return  this.salaRepository.save(sala);
    }

    // izmena
    public Sala izmeni(Sala sala){
        return  this.salaRepository.save(sala);
    }

    // brisanje
    public void delete(Long id){
        this.salaRepository.deleteById(id);
    }

    /*
        PRETRAGA SALA
     */

    public Sala findOne(Long id){
        Sala sala = this.salaRepository.getOne(id);
        return  sala;
    }

    public List<Sala> findAll(){
        List<Sala> salaList = this.salaRepository.findAll();
        return  salaList;
    }
}
