package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.entity.dto.SalaDTO;

import java.util.List;


public interface SalaService {


    // cuvanje
    public Sala saveAndCreate(Sala sala) throws Exception;

    // izmena
     Sala izmeni(Sala sala);

    // brisanje
    void delete(Long id);

    public Sala logickoBrisanje(Long id) throws Exception;

     Sala findOne(Long id);

    List<Sala> findAll();

    List<SalaDTO> findTrenutne(Long id);
}
