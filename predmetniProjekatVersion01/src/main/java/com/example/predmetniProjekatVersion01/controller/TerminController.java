package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.dto.TerminDTO;
import com.example.predmetniProjekatVersion01.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController(value = "/api/termin")
public class TerminController {
    @Autowired
    private TerminService terminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAll(){
        List<Termin> terminList = terminService.findAll();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for (Termin termini : terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(), termini.getBrojPrijavljenihClanova(),
                    termini.getCena(),
                    termini.getTreninzi().getNaziv(),termini.getTreninzi().getOpis(), termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/naziv", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAllDTONaziv(@RequestParam String naziv){
        System.out.println(naziv);

        List<Termin> terminList = terminService.findByNaziv(naziv);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/tip", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAllDTOTip(@RequestParam TipTreninga tipTreninga){
        System.out.println(tipTreninga);

        List<Termin> terminList = terminService.findAllByTipTreninga(tipTreninga);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/opis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAllDTOOpis(@RequestParam String opis){
        System.out.println(opis);

        List<Termin> terminList = terminService.findByOpis(opis);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/pocetakTermina", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAllDTOPocetak(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")Date pocetakTermina){
        System.out.println(pocetakTermina);

        List<Termin> terminList = terminService.findAllVremeGreaterEqual(pocetakTermina);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/cena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAllDTONaziv(@RequestParam double cena){
        System.out.println(cena);

        List<Termin> terminList = terminService.findAllCenaGT(cena);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/rastuciSort-cena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortRastuciCena(){
        List<Termin> terminList = terminService.sortCenaAsc();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/opadajuciSort-cena", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortOpadCena(){
        List<Termin> terminList = terminService.sortCenaDesc();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/rastuciSort-vreme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortRastuciVreme(){
        List<Termin> terminList = terminService.sortVremeAsc();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new  TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/opadajuciSort-vreme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortOpadVreme(){
        List<Termin> terminList = terminService.sortVremeDesc();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(), termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }
}
