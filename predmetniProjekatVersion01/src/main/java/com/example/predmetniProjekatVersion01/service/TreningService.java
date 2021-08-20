package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;

import java.util.List;


public interface TreningService {

    public Trening pronadjiTrening(Long id);
    List<TreningDTO> findAll();

}
