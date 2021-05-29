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

    // *** SORTIRANJE treninga
    // 1. rastuci redosled, po nazivu
    public List<Trening> sort_by_naziv(){
        List<Trening> treningList = treningRepository.findAll(Sort.by(Sort.Direction.ASC, "naziv"));
        return treningList;
    }
    // 2. opadajuci redosled, po ceni
    public  List<Trening> treningList = treningRepository.findAll(Sort.by(Sort.Direction.DESC, "cena"));


}
