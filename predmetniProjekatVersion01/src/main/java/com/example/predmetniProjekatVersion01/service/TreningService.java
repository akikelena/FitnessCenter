package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {

    @Autowired
    private TreningRepository treningRepository;

    // cuvanje
    public Trening save(Trening trening){
        return treningRepository.save(trening);
    }

    // izmena treninga
    public Trening izmeni(Trening trening){
        return  treningRepository.save(trening);
    }

    // brisanje
    public  void delete(Long id){
        treningRepository.deleteById(id);
    }

    // "obicna" pretraga
    public Trening pronadji(Long id){
        Trening trening = this.treningRepository.findById(id);
        return trening;
    }

    public List<Trening> findAll(){
        List<Trening> treningList = this.treningRepository.findAll();
        return  treningList;
    }

}
