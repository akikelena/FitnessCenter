package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;
import com.example.predmetniProjekatVersion01.service.TreningService;
import com.example.predmetniProjekatVersion01.entity.Trening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/trening", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreningController {

    @Autowired
    private TreningService treningService;

    @DeleteMapping(value = "/obrisiTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obrisiTrening(@PathVariable Long id){
        treningService.delete(id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id){
        Trening trening = this.treningService.pronadji(id);

        TreningDTO treningDTO = new TreningDTO();

        treningDTO.setId(trening.getId());
        treningDTO.setNaziv(trening.getNaziv());
        treningDTO.setTipTreninga(trening.getTipTreninga());
        treningDTO.setOpis(trening.getOpis());
        treningDTO.setTrajanje(trening.getTrajanje());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }
}
