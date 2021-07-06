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
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/fcentar")
public class FitnessCentarController {

    @Autowired
    private FitnessCentarService fitnessCentarService;

    // Dobavljanje odredjenog FC-a po ID-u
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFC(@PathVariable Long id){

        Optional<FitnessCentar> fitnessCentar = Optional.ofNullable(fitnessCentarService.findOne(id));

            if(!fitnessCentar.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        FitnessCentar fcentar = fitnessCentar.get();
        FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fcentar.getId(),
                fcentar.getNaziv(), fcentar.getAdresa(), fcentar.getBrTelCentrale(),
                fcentar.getEmail());

        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);

    }

    // Lista svih fitness centara
    @GetMapping(value = "/FCList",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFCs(){

        List<FitnessCentar> fitnessCentarList = fitnessCentarService.findAll();
        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

        for(FitnessCentar fitnessCentar : fitnessCentarList) {
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(),
                    fitnessCentar.getNaziv(), fitnessCentar.getAdresa(),
                    fitnessCentar.getBrTelCentrale(), fitnessCentar.getEmail());

            fitnessCentarDTOS.add(fitnessCentarDTO);
        }
       return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }

    // BRISANJE FCENTRA
    @DeleteMapping(value = "/obrisiFC/{id}")
    public ResponseEntity<Void> obrisiFitnessCentar(@PathVariable Long id){
        this.fitnessCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DODAVANJE FCENTRA
    @PostMapping(value = "/dodajFC",
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
    @PutMapping(value = "/azurirajFC/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> izmeniFitnessCentar(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{

        Optional<FitnessCentar> fitnessCentarOptional = Optional.ofNullable(fitnessCentarService.findOne(id));

            if(!fitnessCentarOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarOptional.get().getId(),
                fitnessCentarDTO.getNaziv(), fitnessCentarDTO.getAdresa(), fitnessCentarDTO.getBrTelCentrale(),
                fitnessCentarDTO.getEmail());

            fitnessCentar = fitnessCentarService.izmeni(fitnessCentar);
            fitnessCentarDTO.setId(id);

            return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.ACCEPTED);

    }

}
