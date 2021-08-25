package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.OcenaDTO;
import com.example.predmetniProjekatVersion01.service.ClanService;
import com.example.predmetniProjekatVersion01.service.OcenaService;
import com.example.predmetniProjekatVersion01.service.TerminService;
import com.example.predmetniProjekatVersion01.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/ocena")
public class OcenaController {

    private final OcenaService ocenaService;
    private final TerminService terminService;
    private final TrenerService trenerService;
    private final ClanService clanService;

    public OcenaController(OcenaService ocenaService,
                           TerminService terminService,
                           TrenerService trenerService,
                           ClanService clanService){
        super();
        this.ocenaService = ocenaService;
        this.terminService = terminService;
        this.trenerService = trenerService;
        this.clanService = clanService;
    }

    @PostMapping(value = "/dodajNovuOcenu",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OcenaDTO> dodajNovuOcenu(@RequestBody OcenaDTO ocenaDTO) throws Exception{
        Ocena novaOcena = new Ocena();

            novaOcena.setOcena(ocenaDTO.getOcena());
            novaOcena.setTermin(this.terminService.findOne(ocenaDTO.getIdTermina()));
            novaOcena.setKorisnik(this.clanService.findOne(ocenaDTO.getIdClana()));

            Ocena cuvaj = this.ocenaService.kreiraj(novaOcena);
            OcenaDTO povratna = new OcenaDTO(
                    cuvaj.getOcena(),
                    cuvaj.getKorisnik().getId(),
                    cuvaj.getTermin().getId());

        Trener trener = this.trenerService.findOne(this.terminService.findOne(ocenaDTO.getIdTermina()).getTrener().getId());

        trener.setProsecnaOcena(this.ocenaService.izracunajProsecnuOcenu(this.terminService.findOne(ocenaDTO.getIdTermina()).getTrener().getId()));
        this.trenerService.save(trener);

        return new ResponseEntity<>(povratna, HttpStatus.OK);
    }

}
