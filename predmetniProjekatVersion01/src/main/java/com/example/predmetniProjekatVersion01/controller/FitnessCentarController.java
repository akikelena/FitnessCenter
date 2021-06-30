package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/fcentar")
public class FitnessCentarController {

    @Autowired
    private FitnessCentarService fitnessCentarService;

    // Dobavljanje odredjenog FC-a po ID-u
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFC(@PathVariable Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);

            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
            fitnessCentarDTO.setId(fitnessCentar.getId());
            fitnessCentarDTO.setNaziv(fitnessCentar.getNaziv());
            fitnessCentarDTO.setAdresa(fitnessCentar.getAdresa());
            fitnessCentarDTO.setBrTelCentrale(fitnessCentar.getBrTelCentrale());
            fitnessCentarDTO.setEmail(fitnessCentar.getEmail());

            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);
    }

    // LISTA SVIH FCENTARA
    @GetMapping(value = "/FCList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFCs(){

        List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.findAll();

        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

        for(FitnessCentar fitnessCentar : fitnessCentarList) {
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(), fitnessCentar.getNaziv(),
                    fitnessCentar.getAdresa(), fitnessCentar.getBrTelCentrale(), fitnessCentar.getEmail());
            fitnessCentarDTOS.add(fitnessCentarDTO);
        }
       return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }

    // BRISANJE FCENTRA
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> obrisiFitnessCentar(@PathVariable Long id){
        this.fitnessCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DODAVANJE FCENTRA
    @PostMapping(value = "/dodaj",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> kreirajNoviFC(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {

        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getId(),
                fitnessCentarDTO.getNaziv(),
                fitnessCentarDTO.getAdresa(), fitnessCentarDTO.getBrTelCentrale(),
                fitnessCentarDTO.getEmail());

       fitnessCentar = fitnessCentarService.save(fitnessCentar);
       fitnessCentarDTO.setId(fitnessCentar.getId());

        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.CREATED);
    }


    // IZMENA FCENTRA
    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> izmeniFitnessCentar(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{

        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getNaziv(), fitnessCentarDTO.getAdresa(),
                fitnessCentarDTO.getBrTelCentrale(), fitnessCentarDTO.getEmail());

        fitnessCentar.setId(id);

        FitnessCentar izmenjenFC = fitnessCentarService.izmeni(fitnessCentar);

        FitnessCentarDTO izmenjenFitnessCentarDTO = new FitnessCentarDTO(izmenjenFC.getId(), izmenjenFC.getNaziv(),
                izmenjenFC.getAdresa(), izmenjenFC.getBrTelCentrale(), izmenjenFC.getEmail());

        return new ResponseEntity<>(izmenjenFitnessCentarDTO, HttpStatus.OK);

    }

}
