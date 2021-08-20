package com.example.predmetniProjekatVersion01.service;


import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.dto.PretragaDTO;
import com.example.predmetniProjekatVersion01.entity.dto.TerminDTO;

import java.util.List;

public interface TerminService {

    Termin findOne(Long id);
    List<Termin> findAll();
    List<Termin> findAllById(Long id);
    List<TerminDTO> findAllPretraga(PretragaDTO pretragaDTO);
    Termin kreiraj(Termin termin) throws Exception;
    Termin izmeni(Termin termin);
    Termin otkaziTermin(Long id);
    void delete(Long id);


}
