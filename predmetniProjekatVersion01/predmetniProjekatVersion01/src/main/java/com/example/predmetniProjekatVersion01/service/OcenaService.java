package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.repository.OcenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcenaService {

    @Autowired
    private OcenaRepository ocenaRepository;

    // cuvanje
    public Ocena save(Ocena ocena){
        return this.ocenaRepository.save(ocena);
    }

    // izmena
    public Ocena izmeni(Ocena ocena){
        return this.ocenaRepository.save(ocena);
    }

    // brisanje
    public void delete(Long id){
        this.ocenaRepository.deleteById(id);
    }

    /*
        Pretraga po ocenama
     */

    public Ocena pronadji(Long id){
        Ocena ocena = this.ocenaRepository.getOne(id);
        return ocena;
    }

    public List<Ocena> findAll(Ocena ocena){
        List<Ocena> ocenaList = this.ocenaRepository.findAll();
        return  ocenaList;
    }
}
