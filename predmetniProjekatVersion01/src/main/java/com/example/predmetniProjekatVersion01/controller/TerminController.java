package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import com.example.predmetniProjekatVersion01.entity.dto.IzabraniTerminDTO;
import com.example.predmetniProjekatVersion01.entity.dto.TerminDTO;
import com.example.predmetniProjekatVersion01.service.KorisnikService;
import com.example.predmetniProjekatVersion01.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/termin")
public class TerminController {
    @Autowired
    private TerminService terminService;

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value = "/TerminList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getAll(){

        List<Termin> terminList = terminService.findAll();
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for (Termin termini : terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
            termini.getPocetakTermina(),
            termini.getBrojPrijavljenihClanova(),
            termini.getCena(),
            termini.getTreninzi().getNaziv(),
            termini.getTreninzi().getOpis(),
            termini.getTreninzi().getTipTreninga(),
            termini.getSale().getOznakaSale());
            terminDTOList.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @PutMapping(value = "/azurirajTermin",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> izmenaTermina(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception{

        Optional<Termin> terminOptional = Optional.ofNullable(terminService.findOne(id));

            if(!terminOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        Termin termin = new Termin(terminOptional.get().getId(),
                terminDTO.getPocetakTermina(), terminDTO.getBrojPrijavljenihClanova(),
                terminDTO.getCena(), terminDTO.getNaziv(), terminDTO.getOpis(),
                terminDTO.getTipTreninga(), terminDTO.getOznakaSale());

            termin = terminService.izmeni(termin);
            terminDTO.setId(id);

            return new ResponseEntity<>(terminDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/naziv",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> pretragaNaziv(@RequestParam String naziv){

        System.out.println(naziv);

        List<Termin> terminList = terminService.findAllByNaziv(naziv);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
                    termini.getBrojPrijavljenihClanova(),
                    termini.getCena(), termini.getTreninzi().getNaziv(),
                    termini.getTreninzi().getOpis(),
                    termini.getTreninzi().getTipTreninga(),
                    termini.getSale().getOznakaSale());

            terminDTOList.add(terminDTO);
        }
        return  new ResponseEntity<>(terminDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/tipTreninga",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> pretragaTipTreninga(@RequestParam TipTreninga tipTreninga){
        System.out.println(tipTreninga);

        List<Termin> terminList = terminService.findAllByTipTreninga(tipTreninga);
        List<TerminDTO> terminDTOList = new ArrayList<>();

        for(Termin termini: terminList){
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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
            TerminDTO terminDTO = new TerminDTO(termini.getId(),
                    termini.getPocetakTermina(),
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

    @PostMapping(value = "/prijaviTrening/{idKorisnik}/{idTermin}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzabraniTerminDTO> prijava(@PathVariable Long idKorisnik,
                                                     @PathVariable Long idTermin){
            Termin termin = terminService.findOne(idTermin);
            Korisnik korisnik = korisnikService.findOne(idKorisnik);

                if(termin == null || korisnik == null ){
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }

                int noviBrojPrijavljenih = termin.getBrojPrijavljenihClanova() + 1;
                termin.setBrojPrijavljenihClanova(noviBrojPrijavljenih);
                korisnikService.save(korisnik);

            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/odjaviTrening/{idKorisnik}/{idTermin}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzabraniTerminDTO> odjava(@PathVariable Long idKorisnik,
                                                    @PathVariable Long idTermin){
        Termin termin = terminService.findOne(idTermin);
        Korisnik korisnik = korisnikService.findOne(idKorisnik);

            if(termin == null || korisnik == null ){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        int noviBrojPrijavljenih = termin.getBrojPrijavljenihClanova() + 1;
        termin.setBrojPrijavljenihClanova(noviBrojPrijavljenih);


        korisnik.getPrijavljeniTermini().remove(termin);

        korisnikService.save(korisnik);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping(value = "/listaOcenjenihTermina/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<IzabraniTerminDTO>> listaOcenjenihTermina(@PathVariable Long id){

        Korisnik korisnik = korisnikService.findOne(id);

            Set<Termin> terminList = korisnik.getPrijavljeniTermini();
            Set<IzabraniTerminDTO> izabraniTerminDTOS = new HashSet<>();

                for(Termin termini : terminList){
                    Set<Ocena> ocenaSet = termini.getOcene();

                        for(Ocena ocene : ocenaSet){
                            if(ocene.getTrener().getId() == id){
                                Date date = new Date();

                                    if(date.after(termini.getPocetakTermina())){
                                        IzabraniTerminDTO izabraniTerminDTO = new IzabraniTerminDTO(termini.getId(),
                                                termini.getPocetakTermina(), termini.getCena(),
                                                termini.getTreninzi().getTipTreninga(), termini.getTreninzi().getNaziv(),
                                                termini.getTreninzi().getOpis(), termini.getTreninzi().getTrajanje(),
                                                termini.getSale().getOznakaSale());

                            izabraniTerminDTOS.add(izabraniTerminDTO);
                                    }
                            }
                        }
                }
        return new ResponseEntity<>(izabraniTerminDTOS, HttpStatus.OK);
    }
}
