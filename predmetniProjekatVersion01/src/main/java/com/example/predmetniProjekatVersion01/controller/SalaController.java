package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.entity.dto.SalaDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import com.example.predmetniProjekatVersion01.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @Autowired
    private FitnessCentarService fitnessCentarService;

    // KREIRANJE NOVE SALE
    @PostMapping(value = "/dodajSalu",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> dodajNovuSalu(@RequestBody SalaDTO salaDTO) throws Exception {

        FitnessCentar fitnessCentar = new FitnessCentar();
        fitnessCentar = fitnessCentarService.findOne(salaDTO.getIdFC());

        Sala sala = new Sala(null, salaDTO.getKapacitet(),
                salaDTO.getOznakaSale(), fitnessCentar);

        sala = salaService.save(sala);
        salaDTO.setId(sala.getId());

        return  new ResponseEntity<>(salaDTO, HttpStatus.CREATED);
    }

    // IZMENA SALE
    @PutMapping(value = "/azurirajSalu/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> izmeniSalu(@PathVariable Long id, @RequestBody SalaDTO salaDTO){
        Optional<Sala> sala = Optional.ofNullable(salaService.findOne(id));

        if(!sala.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        FitnessCentar fitnessCentar = new FitnessCentar();
        fitnessCentar = fitnessCentarService.findOne(salaDTO.getIdFC());
        System.out.println(fitnessCentar.getNaziv());

        Sala sala1 = new Sala(
                sala.get().getId(),
                salaDTO.getKapacitet(), salaDTO.getOznakaSale(),
                fitnessCentar);
        
        System.out.println(sala1.getId());
        System.out.println(sala1.getOznakaSale());
        System.out.println(sala1.getKapacitet());
        
        sala1 = salaService.izmeni(sala1);
        salaDTO.setId(id);
        
        return new ResponseEntity<>(salaDTO, HttpStatus.ACCEPTED);
    }

    // BRISANJE SALE
    @DeleteMapping(value = "/obrisiSalu/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obrisiSalu(@PathVariable Long id){

        this.salaService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}