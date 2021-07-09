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

    @GetMapping(value = "/TerminList",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/naziv",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> pretragaNaziv(@RequestParam String naziv){

        System.out.println(naziv);

        List<Termin> terminList = terminService.findByNaziv(naziv);
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

    @GetMapping(value = "/TerminList/tipTreninga",
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

    @GetMapping(value = "/TerminList/opis",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/pocetakTermina",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/cena",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/rastuciSortCena",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortRastuciCena(){

        List<Termin> terminList = terminService.sortCena();
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

    @GetMapping(value = "/TerminList/opadajuciSortCena",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/rastuciSortVreme",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> sortRastuciVreme(){

        List<Termin> terminList = terminService.sortVreme();
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

    @GetMapping(value = "/TerminList/opadajuciSortVreme",
            produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/TerminList/nasumicanRedosled",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> nasumicanRedosledSort(){

        List<Termin> terminList = terminService.findAll();
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

    @GetMapping(value = "/TerminList/izabraniTermini/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzabraniTerminDTO> izabraniTermini(@PathVariable Long id){

        Termin termin = terminService.findOne(id);

            if(termin == null){
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);

            }

            int trenutniKapacitet = termin.getSale().getKapacitet() - termin.getBrojPrijavljenihClanova();

        IzabraniTerminDTO izabraniTerminDTO = new IzabraniTerminDTO(termin.getId(),
                termin.getPocetakTermina(), termin.getBrojPrijavljenihClanova(),
                termin.getCena(), termin.getTreninzi().getTipTreninga(), termin.getTreninzi().getNaziv(),
                termin.getTreninzi().getOpis(), termin.getSale().getOznakaSale(), trenutniKapacitet);

        return new ResponseEntity<>(izabraniTerminDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/prijaviTrening/{idKorisnik}/{idTermin}",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzabraniTerminDTO> prijava(@PathVariable Long idKorisnik,
                                                     @PathVariable Long idTermin){
            Termin termin = terminService.findOne(idTermin);
            Korisnik korisnik = korisnikService.findOne(idKorisnik);

                System.out.println(korisnik.getIme());
                System.out.println(termin.getCena());

                if(korisnik == null  || termin == null ){
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

    @GetMapping(value = "/TerminList/listaOcenjenihTermina/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<IzabraniTerminDTO>> listaOcenjenihTermina(@PathVariable Long id){

        Korisnik trener = korisnikService.findOne(id);
        System.out.println(trener.getIme());

            Set<Termin> terminList = trener.getPrijavljeniTermini();
            Set<IzabraniTerminDTO> izabraniTerminDTOS = new HashSet<>();

                for(Termin termini : terminList){

                    System.out.println(termini.getCena());
                    Set<Ocena> ocenaSet = termini.getOcene();

                        for(Ocena ocene : ocenaSet){
                            if(ocene.getTrener().getId() == id){
                                Date date = new Date();

                                    if(date.after(termini.getPocetakTermina())){
                                        IzabraniTerminDTO izabraniTerminDTO = new IzabraniTerminDTO(termini.getId(),
                                                termini.getPocetakTermina(), termini.getCena(), termini.getTreninzi().getNaziv(),
                                                termini.getTreninzi().getOpis(), termini.getTreninzi().getTipTreninga(),
                                                termini.getSale().getOznakaSale());

                            izabraniTerminDTOS.add(izabraniTerminDTO);
                            break;
                                    }
                            }
                        }
                }
        return new ResponseEntity<>(izabraniTerminDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/TerminList/listaNeocenjenihTermina/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminDTO>> listaNeocenjenihTermina(@PathVariable Long id){

        Korisnik trener = korisnikService.findOne(id);
        System.out.println(trener.getIme());

        Set<Termin> terminSet = trener.getPrijavljeniTermini();
        Set<TerminDTO> terminDTOSet = new HashSet<>();

            for(Termin termini : terminSet){

                System.out.println(termini.getCena());
                Set<Ocena> ocenaSet = termini.getOcene();
                boolean ocenjenTermin = false; // pocetna pretpostavka - termin nije ocenjen

                    for(Ocena ocene: ocenaSet){
                        if(ocene.getTrener().getId() == id){
                            ocenjenTermin = true;   // ako postoji ocena - izmeniti inicijalnu vrednost promenljive, ali ne ocitavati korisnika
                            break;
                        }
                    }
                        if(ocenjenTermin == false){
                            Date date = new Date();
                            if(date.after(termini.getPocetakTermina())){

                                TerminDTO terminDTO = new TerminDTO(termini.getId(),
                                        termini.getTreninzi().getNaziv(), termini.getTreninzi().getOpis(),
                                        termini.getTreninzi().getTipTreninga(), termini.getSale().getOznakaSale(),
                                        termini.getPocetakTermina(), termini.getCena());

                                terminDTOSet.add(terminDTO);
                                break;
                            }
                        }
            }
            return new ResponseEntity<>(terminDTOSet, HttpStatus.OK);
    }

}
