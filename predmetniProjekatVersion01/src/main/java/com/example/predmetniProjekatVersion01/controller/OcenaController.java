package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/ocena")
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
