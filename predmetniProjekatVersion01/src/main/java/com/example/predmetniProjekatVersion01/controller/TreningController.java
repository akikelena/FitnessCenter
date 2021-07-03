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
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/trening", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreningController {

    @Autowired
    private TreningService treningService;

    // Brisanje treninga po id-u
    @DeleteMapping(value = "/obrisiTrening/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obrisiTrening(@PathVariable Long id){

        treningService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    // Doabavljanje treninga po id-u
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable Long id){
        Optional<Trening> trening = Optional.ofNullable(treningService.pronadji(id));

            if(!trening.isPresent()){   // ako trazeni trening ne postoji

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // vrati info o nepostojecem treningu
            }

        Trening trening1 = trening.get();

            TreningDTO treningDTO = new TreningDTO(trening1.getId(),
                    trening1.getNaziv(), trening1.getOpis(),
                    trening1.getTipTreninga(), trening1.getTrajanje());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }

    // Lista svih treninga
    @GetMapping(value = "/TreningList",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> listaTreninga(){

        List<Trening> treningList = treningService.findAll();
        List<TreningDTO> treningDTOList = new ArrayList<>();

        for(Trening trening : treningList) {

            TreningDTO treningDTO = new TreningDTO(trening.getId(),
                    trening.getNaziv(), trening.getOpis(),
                    trening.getTipTreninga(), trening.getTrajanje());

            treningDTOList.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOList, HttpStatus.OK);
    }

    // Dodavanje treninga
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

    // Izmena treninga
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

