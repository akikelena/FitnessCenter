package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.entity.dto.OcenaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.predmetniProjekatVersion01.service.OcenaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OcenaController {
    @Autowired
    private OcenaService ocenaService;

    /*
    @GetMapping(value = "/ocene", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OcenaDTO>> getAllOcene(OcenaDTO ocenaDTO){
        List<Ocena> ocenaList = ocenaService.findAll();
        List<OcenaDTO> ocenaDTOList = new ArrayList<>();

        for(Ocena ocena: ocenaList){
            String korisnickoIme = ocena.getTrener().getKorisnickoIme();
            System.out.println(ocena.getTermini().getTreninzi());
            if(korisnickoIme == ocenaDTO.getTrenerIme()){
                OcenaDTO ocenaDTO1 = new OcenaDTO(ocena.getTrener().getKorisnickoIme(), ocena.getOcena(),
                        ocena.getTrener().getIme(), ocena.getTrener().getPrezime());
            }
            ocenaDTOList.add(ocenaDTO);
        }
        return new ResponseEntity<>(ocenaDTOList, HttpStatus.OK);
    }   */
}
