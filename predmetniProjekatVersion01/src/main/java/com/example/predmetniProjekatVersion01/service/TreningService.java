package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;

import java.util.List;


public interface TreningService {

    Trening pronadjiTrening(Long id);
    List<TreningDTO> findAll();
    Trening findOne(Long id);
    Trening izmeni(Long id, Trening trening1) throws Exception;
    void delete(Long id);
    Trening save(Trening trening) throws Exception;

}
