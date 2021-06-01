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

    /*  SORTIRANJE treninga
                                */
    // 1. rastuci redosled, po nazivu
    public List<Trening> sort_by_naziv(){
        List<Trening> treningList = treningRepository.findAll(Sort.by(Sort.Direction.ASC, "naziv"));
        return treningList;
    }
    // 2. opadajuci redosled, po ceni
    public  List<Trening> treningList = treningRepository.findAll(Sort.by(Sort.Direction.DESC, "cena"));

    // "obicna" pretraga
    public Trening pronadji(Long id){
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    public List<Trening> findAll(){
        List<Trening> treningList = this.treningRepository.findAll();
        return  treningList;
    }

}
