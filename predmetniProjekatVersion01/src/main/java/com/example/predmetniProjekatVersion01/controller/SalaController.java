package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.entity.dto.SalaDTO;
import com.example.predmetniProjekatVersion01.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/sala")
public class SalaController {

    @Autowired
    private SalaService salaService;

    // KREIRANJE NOVE SALE
    @PostMapping(value = "/dodajSalu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> kreirajNovuSalu(@RequestBody SalaDTO salaDTO) throws Exception {

        Sala sala = new Sala(salaDTO.getId(), salaDTO.getKapacitet(), salaDTO.getOznakaSale());

        sala = salaService.save(sala);
        salaDTO.setId(sala.getId());

        return new ResponseEntity<>(salaDTO, HttpStatus.CREATED);
    }

    /* AZURIRANJE SALE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSalu(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception{

        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznakaSale());
        sala.setId(id);

        Sala updatedSala = salaService.izmeni(sala);

        SalaDTO updatedSalaDTO = new SalaDTO(updatedSala.getId(), updatedSala.getKapacitet(), updatedSala.getOznakaSale());

        return new ResponseEntity<>(updatedSalaDTO, HttpStatus.OK);
    }
*/
    // BRISANJE POSTOJECE SALE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> obrisiSalu(@PathVariable Long id){
        this.salaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
