package com.example.predmetniProjekatVersion01.service;


import com.example.predmetniProjekatVersion01.entity.Ocena;

public interface OcenaService {
    Double izracunajProsecnuOcenu(Long id);
    Ocena kreiraj(Ocena ocena) throws Exception;
}
