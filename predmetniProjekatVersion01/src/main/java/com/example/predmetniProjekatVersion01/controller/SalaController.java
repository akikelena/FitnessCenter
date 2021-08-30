package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.entity.dto.SalaDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import com.example.predmetniProjekatVersion01.service.SalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/sala")
public class SalaController {


    private final SalaService salaService;
    private final FitnessCentarService fitnessCentarService;

    public SalaController(SalaService salaService, FitnessCentarService fitnessCentarService){
        super();
        this.salaService = salaService;
        this.fitnessCentarService = fitnessCentarService;
    }

    // KREIRANJE NOVE SALE
    @PostMapping(value = "/dodajSalu",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> dodajNovuSalu(@RequestBody SalaDTO salaDTO) throws Exception {

        List<Sala> salaList = salaService.findAll();

            for(Sala sala: salaList){
                if(sala.getOznakaSale().equalsIgnoreCase(salaDTO.getOznakaSale())){
                    SalaDTO retval = new SalaDTO(
                            Long.valueOf(0),
                            "nije kreirano",
                            0,
                            Long.valueOf(-1));
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
            }
            Sala novaSala = new Sala();
                novaSala.setFitnessCentar(fitnessCentarService.findOne(salaDTO.getIdFC()));
                novaSala.setSalaSeKoristi(true);
                novaSala.setKapacitet(salaDTO.getKapacitet());
                novaSala.setOznakaSale(salaDTO.getOznakaSale());

            Sala izmenjena = this.salaService.saveAndCreate(novaSala);
            SalaDTO salaDTO1 = new SalaDTO(
                    izmenjena.getId(),
                    izmenjena.getOznakaSale(),
                    izmenjena.getKapacitet(),
                    izmenjena.getFitnessCentar().getId());

        return  new ResponseEntity<>(salaDTO1, HttpStatus.OK);
    }

    // IZMENA SALE
    @PostMapping(value = "/azurirajSalu/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> izmeniSalu(@PathVariable Long id, @RequestBody SalaDTO salaDTO){
        Sala novaSala =salaService.findOne(id);
            if(salaDTO.getIdFC() != 0){
                FitnessCentar novifc = fitnessCentarService.findOne(salaDTO.getIdFC());
                novaSala.setFitnessCentar(novifc);
            }
            if(!salaDTO.getOznakaSale().equals("")){
                List<Sala> salaList = salaService.findAll();
                    for(Sala sala:salaList){
                        if(sala.getOznakaSale().equalsIgnoreCase(salaDTO.getOznakaSale())){
                            SalaDTO povratna = new SalaDTO(
                                    Long.valueOf(0),
                                    "nije kreirano",
                                    0,
                                    Long.valueOf(-1));
                            return new ResponseEntity<>(povratna, HttpStatus.OK);
                        }
                    }
                    novaSala.setOznakaSale(salaDTO.getOznakaSale());
            }
            if(salaDTO.getKapacitet() != -1){
                novaSala.setKapacitet(salaDTO.getKapacitet());
            }

            Sala promenjena = salaService.izmeni(novaSala);
            SalaDTO retval = new  SalaDTO(
                    promenjena.getId(),
                    promenjena.getOznakaSale(),
                    promenjena.getKapacitet(),
                    promenjena.getFitnessCentar().getId());
        
        return new ResponseEntity<>(retval, HttpStatus.OK);
    }


    // LISTA SVIH SALA
    @GetMapping(value = "/SalaList",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> sveSale(){

        List<Sala> salaList = salaService.findAll();
        List<SalaDTO> salaDTOS = new ArrayList<>();

            for(Sala sala : salaList){
                if(sala.getSalaSeKoristi()){
                    SalaDTO salaDTO = new SalaDTO(sala.getId(),
                            sala.getOznakaSale(), sala.getKapacitet(),
                            sala.getFitnessCentar().getId());

                    salaDTOS.add(salaDTO);
                }

            }
        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);

    }

    // lista sala za spec trenera
    @GetMapping(value = "/SalaList/aktivneSale/{idTrenera}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getSaleTrenera(@PathVariable Long idTrenera){
        List<SalaDTO> salaDTOList = this.salaService.findTrenutne(idTrenera);
        return new ResponseEntity<>(salaDTOList, HttpStatus.OK);
    }

    // BRISANJE SALE
    @PutMapping(value = "/SalaList/obrisi/{id}")
    public ResponseEntity<Void> obrisiSalu(@PathVariable Long id) throws Exception {
        this.salaService.logickoBrisanje(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}