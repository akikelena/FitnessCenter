package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.TrenerDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import com.example.predmetniProjekatVersion01.service.OcenaService;
import com.example.predmetniProjekatVersion01.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trener")
public class TrenerController {

    private final TrenerService trenerService;
    private final OcenaService ocenaService;
    private final FitnessCentarService fitnessCentarService;

    public TrenerController(TrenerService trenerService,
                            OcenaService ocenaService,
                            FitnessCentarService fitnessCentarService){
        super();
        this.trenerService = trenerService;
        this.ocenaService = ocenaService;
        this.fitnessCentarService = fitnessCentarService;
    }

    @PostMapping(value = "/dodajTrenera",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> dodajNovogTrenera(@RequestBody TrenerDTO trenerDTO) throws Exception{

        List<Trener> treneri = trenerService.findAll();
        for(Trener trener : treneri) {
            if(trener.getKorisnickoIme().equalsIgnoreCase(trenerDTO.getKorisnickoIme())) {
                TrenerDTO newTrenerDTO = new TrenerDTO(
                        Long.valueOf(1),
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        trener.getDatumRodjenja(),
                        "nije kreirano",
                        false,
                        1,
                        Long.valueOf(0));
                return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
            }
            if(trener.getEmail().equalsIgnoreCase(trenerDTO.getEmail())) {
                TrenerDTO newTrenerDTO = new TrenerDTO(
                        Long.valueOf(1),
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        trener.getDatumRodjenja(),
                        "nije kreirano",
                        false,
                        2,
                        Long.valueOf(0));
                return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
            }
            if(trener.getKontaktTelefon().equalsIgnoreCase(trenerDTO.getKontaktTelefon())) {
                TrenerDTO newTrenerDTO = new TrenerDTO(
                        Long.valueOf(1),
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        "nije kreirano",
                        trener.getDatumRodjenja(),
                        "nije kreirano",
                        false,
                        3,
                        Long.valueOf(0));
                return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
            }

        }

        FitnessCentar fc = fitnessCentarService.findOne(trenerDTO.getIdFC());

        Trener trener = new Trener(
                trenerDTO.getKorisnickoIme(),
                trenerDTO.getIme(),
                trenerDTO.getPrezime(),
                trenerDTO.getLozinka(),
                trenerDTO.getEmail(),
                trenerDTO.getDatumRodjenja(),
                trenerDTO.getKontaktTelefon(),
                trenerDTO.isAktivan(),
                false,
                fc);

        Trener newTrener = trenerService.kreiraj(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(newTrener.getId(), newTrener.getKorisnickoIme(), newTrener.getIme(), newTrener.getPrezime(), newTrener.getLozinka(),
                newTrener.getEmail(), newTrener.getDatumRodjenja(), newTrener.getKontaktTelefon(), newTrener.isAktivan(), 0, newTrener.getFitnessCentar().getId()); //newClan

        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/zahteviZaTrenera/{rola}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getZahteve(@PathVariable Integer rola) {

        if(rola == 1) {

            List<TrenerDTO> treneriList = this.trenerService.findZahteveTrenera();
            return new ResponseEntity<>(treneriList, HttpStatus.OK);
        } else {
            List<TrenerDTO> treneriList = new ArrayList<>();
            return new ResponseEntity<>(treneriList, HttpStatus.OK);
        }

    }

    @GetMapping(value = "/aktivniTreneri/{rola}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrenerDTO>> getAktivneTrenere(@PathVariable Integer rola) {

        if(rola == 1) {
            List<TrenerDTO> treneriList = this.trenerService.findAktivne();
            return new ResponseEntity<>(treneriList, HttpStatus.OK);
        } else {
            List<TrenerDTO> treneriList = new ArrayList<>();
            return new ResponseEntity<>(treneriList, HttpStatus.OK);
        }

    }

    @GetMapping(value = "/profil/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> getAktivne(@PathVariable Long id) {

        Trener trener = this.trenerService.findOne(id);

        trener.setProsecnaOcena(this.ocenaService.izracunajProsecnuOcenu(id));
        this.trenerService.save(trener);

        TrenerDTO retVal = new TrenerDTO(
                trener.getId(),
                trener.getKorisnickoIme(),
                trener.getIme(),
                trener.getPrezime(),
                "********",
                trener.getEmail(),
                trener.getDatumRodjenja(),
                trener.getKontaktTelefon(),
                trener.isAktivan(),
                trener.getProsecnaOcena(),
                0,
                trener.getFitnessCentar().getId());


        return new ResponseEntity<>(retVal, HttpStatus.OK);

    }

    @PutMapping(value = "/aktivirajTrenera/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> prihvatiTrenera(@PathVariable Long id) throws Exception {
        Trener trener = trenerService.aktivirajTrenera(id);
        TrenerDTO trenerDTO = new TrenerDTO(
                trener.getId(),
                trener.getKorisnickoIme(),
                trener.getIme(),
                trener.getPrezime(),
                "unavalible",
                trener.getEmail(),
                trener.getDatumRodjenja(),
                trener.getKontaktTelefon(),
                trener.isAktivan(),
                0,
                trener.getFitnessCentar().getId());


        return new ResponseEntity<>(trenerDTO, HttpStatus.OK);
    }
    @PutMapping(value = "/odbijZahtevTrenera/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> odbijTrenera(@PathVariable Long id) throws Exception {

        trenerService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/obrisiTrenera/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> obrisiTrenera(@PathVariable Long id) throws Exception {

        trenerService.logickoBrisanje(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
