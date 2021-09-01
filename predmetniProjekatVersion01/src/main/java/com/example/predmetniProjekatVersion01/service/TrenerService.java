package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.IzmenaProfila;
import com.example.predmetniProjekatVersion01.entity.dto.TrenerDTO;

import java.util.List;

public interface TrenerService {
    Trener findOne(Long id);
    List<Trener> findAll();
    List<TrenerDTO> findAktivne();
    List<TrenerDTO> findZahteveTrenera();
    Trener aktivirajTrenera(Long id) throws Exception;
    Trener kreiraj(Trener trener) throws Exception;
    Trener logickoBrisanje(Long id) throws Exception;

    void save(Trener trener);
    void delete(Long id);

    Trener izmeni(Long idFC, IzmenaProfila fitnessCentarDTO) throws Exception;
}
