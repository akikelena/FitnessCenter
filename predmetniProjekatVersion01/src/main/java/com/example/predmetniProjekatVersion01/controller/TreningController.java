package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;
import com.example.predmetniProjekatVersion01.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/trening", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreningController {

    @Autowired
    private final TreningService treningService;

    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }

    // Doabavljanje treninga po id-u
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> getTrening(@PathVariable Long id){
        Optional<Trening> trening = Optional.ofNullable(treningService.pronadjiTrening(id));

            if(!trening.isPresent()){   // ako trazeni trening ne postoji

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // vrati info o nepostojecem treningu
            }

        Trening trening1 = trening.get();

            TreningDTO treningDTO = new TreningDTO(trening1.getId(),
                    trening1.getNaziv(), trening1.getOpis(),
                    trening1.getTipTreninga());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }


    // Lista svih treninga
    @GetMapping(value = "/TreningList",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> listaTreninga(){

        List<TreningDTO> treningDTOList = this.treningService.findAll();

        return new ResponseEntity<>(treningDTOList, HttpStatus.OK);
    }

    // Dodavanje treninga
    @PostMapping(value = "/dodajTrening",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> dodajTrening(@RequestBody TreningDTO treningDTO) throws Exception{

        Trening trening = new Trening(
                treningDTO.getId(),
                treningDTO.getNaziv(),
                treningDTO.getOpis(),
                treningDTO.getTipTreninga());

        trening = treningService.save(trening);
        treningDTO.setId(trening.getId());

        return new ResponseEntity<>(treningDTO, HttpStatus.CREATED);
    }


    // Izmena treninga
    @PutMapping(value = "/azurirajTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> izmeniTr(@PathVariable Long id, @RequestBody TreningDTO t1) throws Exception {
        Optional<Trening> t2 = Optional.ofNullable(treningService.findOne(id));

            if(!t2.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        Trening trening = new Trening(
                t2.get().getId(),
                t1.getNaziv(),
                t1.getOpis(),
                t1.getTipTreninga());

        trening = treningService.izmeni( trening.getId(), trening);
        t1.setId(id);

        return new ResponseEntity<>(t1, HttpStatus.ACCEPTED);
    }

    // BRISANJE treninga
    @DeleteMapping(value = "/TreningList/{id}")
    public ResponseEntity<Void> obrisiTrening(@PathVariable Long id){
        this.treningService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

