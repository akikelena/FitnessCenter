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

@RestController
@RequestMapping(value = "/api/fcentar")
public class FitnessCentarController {

    @Autowired
    private FitnessCentarService fitnessCentarService;

    // Dobavljanje odredjenog FC-a po ID-u
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFC(@PathVariable Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarService.pronadji(id);

            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
            fitnessCentarDTO.setId(fitnessCentar.getId());
            fitnessCentarDTO.setNaziv(fitnessCentar.getNaziv());
            fitnessCentarDTO.setAdresa(fitnessCentar.getAdresa());
            fitnessCentarDTO.setBrTelCentrale(fitnessCentar.getBrTelCentrale());
            fitnessCentarDTO.setEmail(fitnessCentar.getEmail());

            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);


    }

    // Dobavljanje svih postojecih FC-a
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFCs(){
        List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.pretrazi_sve();

        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

        for(FitnessCentar fitnessCentar : fitnessCentarList) {
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(), fitnessCentar.getNaziv(), fitnessCentar.getAdresa(), fitnessCentar.getBrTelCentrale(), fitnessCentar.getEmail());
            fitnessCentarDTOS.add(fitnessCentarDTO);
        }
       return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }

    // Brisanje postojeceg FC-a
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> obrisiFitnessCentar(@PathVariable Long id){
        this.fitnessCentarService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Dodavanje novog FC-a
    @PostMapping(value = "/dodaj", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> kreirajNoviFC(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {
        FitnessCentar fitnessCentar = new FitnessCentar();

        FitnessCentar newFitnessCentar = fitnessCentarService.save(fitnessCentar);

        FitnessCentarDTO newFitnessCentarDTO = new FitnessCentarDTO(newFitnessCentar.getId(), newFitnessCentar.getNaziv(),
                newFitnessCentar.getAdresa(), newFitnessCentar.getBrTelCentrale(), newFitnessCentar.getEmail());

        return new ResponseEntity<>(newFitnessCentarDTO, HttpStatus.CREATED);
    }

    /*
    // Izmena postojeceg FC-a
    @PutMapping(value = "/izmeni/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> izmeniFitnessCentar(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnessCentarDTO){
        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getNaziv(), fitnessCentarDTO.getAdresa(), fitnessCentarDTO.getBrTelCentrale(), fitnessCentarDTO.getEmail());

        fitnessCentar.setId(id);

        FitnessCentar izmenjenFC = fitnessCentarService.izmeni(fitnessCentar);

        FitnessCentarDTO izmenjenFitnessCentarDTO = new FitnessCentarDTO(izmenjenFC.getId(), izmenjenFC.getNaziv(),
                izmenjenFC.getAdresa(), izmenjenFC.getBrTelCentrale(), izmenjenFC.getEmail());
        return new ResponseEntity<>(izmenjenFitnessCentarDTO, HttpStatus.OK);

    }   */
}
