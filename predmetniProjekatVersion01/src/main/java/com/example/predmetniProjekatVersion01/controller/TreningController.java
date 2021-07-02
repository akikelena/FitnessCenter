package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.service.TreningService;
import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;
import com.example.predmetniProjekatVersion01.entity.Trening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/trening", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TreningList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getAll(){

        List<Trening> treningList = treningService.findAll();
        List<TreningDTO> treningDTOList = new ArrayList<>();

        for(Trening trening : treningList) {
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());
            treningDTOList.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/dodajTrening",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> dodajTrening(@RequestBody TreningDTO treningDTO) throws Exception{

        Trening trening = new Trening(treningDTO.getId(), treningDTO.getNaziv(),
                treningDTO.getOpis(), treningDTO.getTipTreninga(),
                treningDTO.getTrajanje());

        trening = treningService.save(trening);
        treningDTO.setId(trening.getId());

        return new ResponseEntity<>(treningDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/azurirajTrening", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> izmeniTr(@PathVariable Long id, @RequestBody TreningDTO treningDTO){
        Trening trening = treningService.pronadji(id);

        Trening trening1 = new Trening(trening.getId(), trening.getNaziv(),
                trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());

        trening1 = treningService.izmeni(trening1);
        treningDTO.setId(id);

        return new ResponseEntity<>(treningDTO, HttpStatus.ACCEPTED);
    }

}

