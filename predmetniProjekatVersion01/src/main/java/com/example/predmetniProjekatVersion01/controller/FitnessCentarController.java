package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;
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
@RequestMapping(value = "/fcentar")
public class FitnessCentarController {


    private final FitnessCentarService fitnessCentarService;
    private final SalaService salaService;

    public FitnessCentarController(FitnessCentarService fitnessCentarService, SalaService salaService){
        super();
        this.fitnessCentarService = fitnessCentarService;
        this.salaService = salaService;
    }

    // Lista svih fitness centara
    @GetMapping(value = "/FCList/{rola}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFCs(@PathVariable Integer rola){

        if(rola == 1){
            List<FitnessCentarDTO> fitnessCentarDTOList = this.fitnessCentarService.findSpecCentre();
            return new ResponseEntity<>(fitnessCentarDTOList, HttpStatus.OK);
        } else {
            List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();
            return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
        }
    }

    // BRISANJE FCENTRA
    @DeleteMapping(value = "/FCList/obrisi/{id}")
    public ResponseEntity<Void> obrisiFitnessCentar(@PathVariable Long id) throws Exception{
        this.fitnessCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DODAVANJE FCENTRA
    @PostMapping(value = "/dodajFC",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> kreirajNoviFC(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception {

        List<FitnessCentar> fitnessCentarList = fitnessCentarService.findAll();
            for(FitnessCentar fitnessCentar: fitnessCentarList){
                if(fitnessCentar.getEmail().equalsIgnoreCase(fitnessCentarDTO.getEmail())){
                    FitnessCentarDTO noviDTOfc = new FitnessCentarDTO(
                            Long.valueOf(0),
                            "nije kreiran",
                            "nije kreiran",
                            "nije kreiran",
                            "nije kreiran",
                            2);
                    return new ResponseEntity<>(noviDTOfc, HttpStatus.CREATED);
                }
                if(fitnessCentar.getBrTelCentrale().equals(fitnessCentarDTO.getBrTelCentrale())){
                    FitnessCentarDTO noviFCDTO = new FitnessCentarDTO(
                            Long.valueOf(0),
                            "nije kreiran",
                            "nije kreiran",
                            "nije kreiran",
                            "nije kreiran",
                            3);
                    return new ResponseEntity<>(noviFCDTO, HttpStatus.CREATED);
                }
            }
                if(fitnessCentarDTO.getRola() == 1){
                    FitnessCentar centar = new FitnessCentar(
                            fitnessCentarDTO.getNaziv(),
                            fitnessCentarDTO.getAdresa(),
                            fitnessCentarDTO.getBrTelCentrale(),
                            fitnessCentarDTO.getEmail(),
                            false);
                    FitnessCentar novi = fitnessCentarService.saveOrCreate(centar);

                    FitnessCentarDTO noviDTO = new FitnessCentarDTO(
                            novi.getId(),
                            novi.getNaziv(),
                            novi.getAdresa(),
                            novi.getBrTelCentrale(),
                            novi.getEmail(),
                            0);
                    return new ResponseEntity<>(noviDTO, HttpStatus.CREATED);
                } else {
                    FitnessCentarDTO centarDTO = new FitnessCentarDTO(
                            Long.valueOf(0),
                            "nije kreirano",
                            "nije kreirano",
                            "nije kreirano",
                            "nije kreirano",
                            1);
                    return new ResponseEntity<>(centarDTO, HttpStatus.CREATED);
                }
    }


    // IZMENA FCENTRA
    @PutMapping(value = "/azurirajFC/{idFC}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> izmeniFitnessCentar(@PathVariable Long idFC, @RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{

        if(fitnessCentarDTO.getRola() == 1){
            List<FitnessCentar> fitnessCentarList = fitnessCentarService.findAll();
                for(FitnessCentar fitnessCentar: fitnessCentarList){
                    if(fitnessCentar.getBrTelCentrale().equals(fitnessCentarDTO.getBrTelCentrale())){
                        FitnessCentarDTO retval = new FitnessCentarDTO(
                                Long.valueOf(0),
                                "bez promene",
                                "bez promene",
                                "bez promene",
                                "bez promene",
                                2);
                        return new ResponseEntity<>(retval, HttpStatus.OK);
                    }
                    if(fitnessCentar.getEmail().equals(fitnessCentarDTO.getEmail())){
                        FitnessCentarDTO retval = new FitnessCentarDTO(
                                Long.valueOf(0),
                                "bez promene",
                                "bez promene",
                                "bez promene",
                                "bez promene",
                                3);
                        return new ResponseEntity<>(retval, HttpStatus.OK);
                    }
                }
                FitnessCentar izmenjen = this.fitnessCentarService.izmeni(idFC, fitnessCentarDTO);
                FitnessCentarDTO povratni = new FitnessCentarDTO(
                        izmenjen.getId(),
                        izmenjen.getNaziv(),
                        izmenjen.getAdresa(),
                        izmenjen.getBrTelCentrale(),
                        izmenjen.getEmail(),
                        0);
                return new ResponseEntity<>(povratni, HttpStatus.OK);
        } else {
            FitnessCentarDTO fitnessCentarDTO1 = new FitnessCentarDTO(
                    Long.valueOf(0),
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    1);
            return new ResponseEntity<>(fitnessCentarDTO1, HttpStatus.OK);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/centri/regTrenera")
    public ResponseEntity<List<FitnessCentarDTO>> getCentreZaReg() {


        List<FitnessCentarDTO> centriList = this.fitnessCentarService.findSpecCentre();
        return new ResponseEntity<>(centriList, HttpStatus.OK);

    }

}
