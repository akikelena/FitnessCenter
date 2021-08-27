package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.BrojacMesta;
import com.example.predmetniProjekatVersion01.entity.dto.PretragaDTO;
import com.example.predmetniProjekatVersion01.entity.dto.TerminDTO;
import com.example.predmetniProjekatVersion01.entity.dto.TerminPt2DTO;
import com.example.predmetniProjekatVersion01.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/termin")
public class TerminController {

    private final TerminService terminService;
    private final SalaService salaService;
    private final OcenaService ocenaService;
    private final ClanService clanService;
    private final TrenerService trenerService;
    private final TreningService treningService;

    public TerminController(TerminService terminService,
                            SalaService salaService,
                            OcenaService ocenaService,
                            ClanService clanService,
                            TrenerService trenerService,
                            TreningService treningService) {
        super();
        this.terminService = terminService;
        this.salaService = salaService;
        this.ocenaService = ocenaService;
        this.clanService = clanService;
        this.trenerService = trenerService;
        this.treningService = treningService;
    }

    @PostMapping(value = "/dodajNoviTermin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> dodajNoviTermin(@RequestBody TerminPt2DTO pt2DTO) throws Exception {
        List<Termin> sviTermini = terminService.findAll();
        for (Termin termin : sviTermini) {
            if (termin.getSale().getId() == pt2DTO.getIdSale()) {
                if ((pt2DTO.getPocetakTermina().before(termin.getKrajTermina()) && pt2DTO.getPocetakTermina().after(termin.getPocetakTermina())) ||
                        (pt2DTO.getKrajTermina().before(termin.getKrajTermina()) && pt2DTO.getKrajTermina().after(termin.getPocetakTermina())) ||
                        (pt2DTO.getKrajTermina().after(termin.getKrajTermina()) && pt2DTO.getPocetakTermina().before(termin.getPocetakTermina())) ||
                        pt2DTO.getKrajTermina().equals(termin.getKrajTermina()) || pt2DTO.getPocetakTermina().equals(termin.getPocetakTermina())) {
                    TerminDTO retVal = new TerminDTO(Long.valueOf(0), termin.getPocetakTermina(), termin.getKrajTermina(), -1, 0, "not set", "not set", "not set");
                    return new ResponseEntity<>(retVal, HttpStatus.OK);
                }
            }
        }
        Termin newTermin = new Termin();
        newTermin.setCena(pt2DTO.getCena());
        newTermin.setPocetakTermina(pt2DTO.getPocetakTermina());
        newTermin.setKrajTermina(pt2DTO.getKrajTermina());
        newTermin.setTrajanjeTermina(pt2DTO.getTrajanjeTermina());
        newTermin.setOtkazan(false);
        newTermin.setSale(salaService.findOne(pt2DTO.getIdSale()));
        newTermin.setTrener(trenerService.findOne(pt2DTO.getIdTrenera()));
        newTermin.setTrening(treningService.findOne(pt2DTO.getIdTreninga()));


        Termin terminRV = this.terminService.kreiraj(newTermin);
        TerminDTO retVal = new TerminDTO(
                terminRV.getId(),
                terminRV.getPocetakTermina(),
                terminRV.getKrajTermina(),
                terminRV.getTrajanjeTermina(),
                terminRV.getCena(),
                terminRV.getTrening().getNaziv(),
                terminRV.getTrening().getOpis(),
                terminRV.getTrening().getTipTreninga());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @PostMapping(value = "/izmeniTermin/{idTermina}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> noviTermin(@RequestBody TerminPt2DTO newTerminDTO, @PathVariable Long idTermina) throws Exception {

        Termin newTermin = this.terminService.findOne(idTermina);

        if (newTerminDTO.getCena() >= 0) {
            newTermin.setCena(newTerminDTO.getCena());
        }
        if (newTerminDTO.getIdSale() > 0) {
            newTermin.setSale(salaService.findOne(newTerminDTO.getIdSale()));
        }
        @SuppressWarnings("deprecation")
        Date ref = new Date(125, 12, 31);

        if (newTerminDTO.getPocetakTermina().before(ref) && newTerminDTO.getKrajTermina().before(ref)) {
            List<Termin> sviTermini = terminService.findAll();
            for (Termin termin : sviTermini) {
                //System.out.println(termin.getSala().getId() + "==" + newTermin.getSala().getId() + " | " + (termin.getSala().getId() == newTermin.getSala().getId()));
                if (termin.getSale().getId() == newTermin.getSale().getId()) {
                    if (termin.getId() != newTermin.getId()) {
                        if ((newTerminDTO.getPocetakTermina().before(termin.getKrajTermina()) && newTerminDTO.getPocetakTermina().after(termin.getPocetakTermina())) ||
                                (newTerminDTO.getKrajTermina().before(termin.getKrajTermina()) && newTerminDTO.getKrajTermina().after(termin.getPocetakTermina())) ||
                                (newTerminDTO.getKrajTermina().after(termin.getKrajTermina()) && newTerminDTO.getPocetakTermina().before(termin.getPocetakTermina())) ||
                                newTerminDTO.getKrajTermina().equals(termin.getKrajTermina()) || newTerminDTO.getPocetakTermina().equals(termin.getPocetakTermina())) {
                            System.out.println(termin.getId());
                            TerminDTO retVal = new TerminDTO(Long.valueOf(0), termin.getPocetakTermina(), termin.getKrajTermina(), -1, 0, "not set", "not set", "not set");
                            return new ResponseEntity<>(retVal, HttpStatus.OK);
                        }
                    }
                }
            }
            newTermin.setPocetakTermina(newTerminDTO.getPocetakTermina());
            newTermin.setKrajTermina(newTerminDTO.getKrajTermina());
            newTermin.setTrajanjeTermina(newTerminDTO.getTrajanjeTermina());
        }
        if(newTerminDTO.getIdTreninga() > 0) {
            newTermin.setTrening(treningService.findOne(newTerminDTO.getIdTreninga()));
        }

        Termin terminRV = this.terminService.izmeni(newTermin);
        TerminDTO retVal = new TerminDTO(terminRV.getId(),
                terminRV.getPocetakTermina(),
                terminRV.getKrajTermina(),
                terminRV.getTrajanjeTermina(),
                terminRV.getCena(),
                terminRV.getTrening().getNaziv(),
                terminRV.getTrening().getOpis(),
                terminRV.getTrening().getTipTreninga());

        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @PutMapping(value = "/otkaziTermin/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> otkaziTermin(@PathVariable Long id) throws Exception {

        Termin terminRV = this.terminService.otkaziTermin(id);
        TerminDTO retVal = new TerminDTO(terminRV.getId(),
                terminRV.getPocetakTermina(),
                terminRV.getKrajTermina(),
                terminRV.getTrajanjeTermina(),
                terminRV.getCena(),
                terminRV.getTrening().getNaziv(),
                terminRV.getTrening().getOpis(),
                terminRV.getTrening().getTipTreninga());


        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }

    @PostMapping(value = "/prijaviTermin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrojacMesta> prijaviTermin(@RequestBody BrojacMesta info) throws Exception {


        Termin newTermin = this.terminService.findOne(info.getIdTermina());
        Clan clan = this.clanService.findOne(info.idClana);
        if(newTermin.getClanovi_neodradjeni().size() >= newTermin.getSale().getKapacitet()) {
            BrojacMesta retVal = new BrojacMesta(Long.valueOf(0), Long.valueOf(0), -1);
            return new ResponseEntity<>(retVal, HttpStatus.OK);
        }
        //System.out.println("PROLAZ?");
        Set<Termin> updatedSet = clan.getNeodradjeniTermini();

        updatedSet.add(newTermin);
        clan.setNeodradjeniTermini(updatedSet);
        this.clanService.save(clan);


        BrojacMesta retVal = new BrojacMesta(Long.valueOf(0), Long.valueOf(0), 0);
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    @PostMapping( value = "/odjaviTermin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BrojacMesta> odjaviTermin(@RequestBody BrojacMesta info) throws Exception {


        Clan clan = this.clanService.findOne(info.idClana);

        Set<Termin> originalSet = clan.getNeodradjeniTermini();
        Set<Termin> updatedSet = new HashSet<>();

        for(Termin termin : originalSet) {
            if(termin.getId() != info.getIdTermina()) {
                updatedSet.add(termin);
            }
        }
        clan.setNeodradjeniTermini(updatedSet);
        this.clanService.save(clan);


        BrojacMesta retVal = new BrojacMesta(Long.valueOf(0), Long.valueOf(0), 0);
        return new ResponseEntity<>(retVal, HttpStatus.OK);
    }
    @GetMapping( value = "/prijavljeniTermini/{idClana}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPt2DTO>> getPrijavljeneTermine(@PathVariable Long idClana) {


        Clan clan = this.clanService.findOne(idClana);

        Set<Termin> termini = clan.getNeodradjeniTermini();
        Set<Termin> termini1 = clan.getOdradjeniTermini();
        Set<Termin> terminiNO = new HashSet<>();
        Set<Termin> terminiO = new HashSet<>();

        java.util.Date current=new java.util.Date();

        List<TerminPt2DTO> terminDTOS = new ArrayList<>();
        for(Termin termin : termini1) {
            terminiO.add(termin);
        }
        for(Termin termin : termini) {
            if(termin.getKrajTermina().before(current)) {
                terminiO.add(termin);
            } else {
                terminiNO.add(termin);
                TerminPt2DTO terminDTO = new TerminPt2DTO(
                        termin.getId(),
                        termin.getPocetakTermina(),
                        termin.getKrajTermina(),
                        termin.getTrajanjeTermina(),
                        termin.getCena(),
                        termin.getTrening().getNaziv(),
                        termin.getTrening().getOpis(),
                        termin.getTrening().getTipTreninga(),
                        termin.getTrening().getId(),
                        termin.getTrener().getId(),
                        termin.getSale().getId(),
                        termin.getSale().getOznakaSale(),
                        termin.getTrener().getKorisnickoIme(),
                        0.0);
                terminDTOS.add(terminDTO);
            }

        }
        clan.setNeodradjeniTermini(terminiNO);
        clan.setOdradjeniTermini(terminiO);
        this.clanService.save(clan);
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    @GetMapping( value = "/ocenjeniTermini/{idClana}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPt2DTO>> getOcenjene(@PathVariable Long idClana) {


        Clan clan = this.clanService.findOne(idClana);

        Set<Termin> termini = clan.getOdradjeniTermini();
        Set<Ocena> ocene = clan.getOcene();

        List<TerminPt2DTO> terminDTOS = new ArrayList<>();

        for(Termin termin : termini) {
            for(Ocena ocena : ocene) {
                if(ocena.getTermin().getId() == termin.getId()) {
                    TerminPt2DTO terminDTO = new TerminPt2DTO(
                            termin.getId(),
                            termin.getPocetakTermina(),
                            termin.getKrajTermina(),
                            termin.getTrajanjeTermina(),
                            termin.getCena(),
                            termin.getTrening().getNaziv(),
                            termin.getTrening().getOpis(),
                            termin.getTrening().getTipTreninga(),
                            termin.getTrening().getId(),
                            termin.getTrener().getId(),
                            termin.getSale().getId(),
                            termin.getSale().getOznakaSale(),
                            termin.getTrener().getKorisnickoIme(),
                            ocena.getOcena());
                    terminDTOS.add(terminDTO);
                }
            }

        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/neocenjeniTermini/{idClana}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPt2DTO>> getTermineZaClana2(@PathVariable Long idClana) {


        Clan clan = this.clanService.findOne(idClana);

        Set<Termin> termini = clan.getOdradjeniTermini();
        Set<Ocena> ocene = clan.getOcene();

        List<TerminPt2DTO> terminDTOS = new ArrayList<>();

        for(Termin termin : termini) {
            boolean x = false;
            for(Ocena ocena : ocene) {
                if(ocena.getTermin().getId() == termin.getId()) {
                    x = true;
                }
            }
            if(!x) {
                TerminPt2DTO terminDTO = new TerminPt2DTO(
                        termin.getId(),
                        termin.getPocetakTermina(),
                        termin.getKrajTermina(),
                        termin.getTrajanjeTermina(),
                        termin.getCena(),
                        termin.getTrening().getNaziv(),
                        termin.getTrening().getOpis(),
                        termin.getTrening().getTipTreninga(),
                        termin.getTrening().getId(),
                        termin.getTrener().getId(),
                        termin.getSale().getId(),
                        termin.getSale().getOznakaSale(),
                        termin.getTrener().getKorisnickoIme(),
                        0.0);
                terminDTOS.add(terminDTO);
            }

        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping( value = "/oTerminu/{idTermina}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminPt2DTO> getTerminZaClana(@PathVariable Long idTermina) {

        Termin termin = this.terminService.findOne(idTermina);

        Trener trener = this.trenerService.findOne(termin.getTrener().getId());
        trener.setProsecnaOcena(this.ocenaService.izracunajProsecnuOcenu(trener.getId()));
        this.trenerService.save(trener);

        TerminPt2DTO terminDTO = new TerminPt2DTO(
                termin.getId(),
                termin.getPocetakTermina(),
                termin.getKrajTermina(),
                termin.getTrajanjeTermina(),
                termin.getCena(),
                termin.getTrening().getNaziv(),
                termin.getTrening().getOpis(),
                termin.getTrening().getTipTreninga(),
                termin.getTrening().getId(),
                termin.getTrener().getId(),
                termin.getSale().getId(),
                termin.getSale().getOznakaSale(),
                termin.getTrener().getKorisnickoIme(),
                termin.getTrener().getProsecnaOcena());


        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

    @GetMapping( value = "/zahtevi",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini() {


        List<Termin> terminiList = this.terminService.findAll();


        List<TerminDTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminiList) {

            TerminDTO terminDTO = new TerminDTO(
                    termin.getId(),
                    termin.getPocetakTermina(),
                    termin.getKrajTermina(),
                    termin.getTrajanjeTermina(),
                    termin.getCena(),
                    "-",
                    "-",
                    "-");
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    @GetMapping(value = "/get/{idTrenera}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminPt2DTO>> getTermineZaTrenera(@PathVariable Long idTrenera) {


        List<Termin> terminiList = this.terminService.findAllById(idTrenera);


        List<TerminPt2DTO> terminDTOS = new ArrayList<>();

        for (Termin termin : terminiList) {

            TerminPt2DTO terminDTO = new TerminPt2DTO(
                    termin.getId(),
                    termin.getPocetakTermina(),
                    termin.getKrajTermina(),
                    termin.getTrajanjeTermina(),
                    termin.getCena(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getId(),
                    termin.getTrener().getId(),
                    termin.getSale().getId(),
                    termin.getSale().getOznakaSale(),
                    termin.getTrener().getKorisnickoIme(),
                    0.0);
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }


    @PostMapping(value = "/criteria",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiByCrit(@RequestBody PretragaDTO searchInDTO) throws Exception {

        PretragaDTO searchDTO = new PretragaDTO(
                searchInDTO.getMaxCena(),
                searchInDTO.getMaxTrajanje(),
                searchInDTO.getTipTreninga(),
                searchInDTO.getNaziv(),
                searchInDTO.getOpis(),
                searchInDTO.getDoDatuma(),
                searchInDTO.isSve());


        List<TerminDTO> terminiDTOS = this.terminService.findAllPretraga(searchDTO);

        return new ResponseEntity<>(terminiDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/criteriaPrijava/{idClana}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTerminiByCritPrijava(@RequestBody PretragaDTO searchInDTO, @PathVariable Long idClana) throws Exception {

        PretragaDTO searchDTO = new PretragaDTO(
                searchInDTO.getMaxCena(),
                searchInDTO.getMaxTrajanje(),
                searchInDTO.getTipTreninga(),
                searchInDTO.getNaziv(),
                searchInDTO.getOpis(),
                searchInDTO.getDoDatuma(),
                searchInDTO.isSve());


        List<TerminDTO> terminiDTOS = this.terminService.findAllPretraga(searchDTO);

        Set<Termin> neodradjeniTermini = this.clanService.findOne(idClana).getNeodradjeniTermini();


        List<TerminDTO> terminiOdradjeni = new ArrayList<>();

        for(TerminDTO termin : terminiDTOS) {
            boolean x = false;
            for(Termin terminNO : neodradjeniTermini) {
                if(termin.getId() == terminNO.getId()) {
                    x = true;
                }
            }
            if(!x) {
                terminiOdradjeni.add(termin);
            }
        }
        List<TerminDTO> terminiDostupni = new ArrayList<>();
        java.util.Date date=new java.util.Date();
        for(TerminDTO termin : terminiOdradjeni) {
            if(termin.getPocetakTermina().after(date)) {
                terminiDostupni.add(termin);
            }
        }



        return new ResponseEntity<>(terminiDostupni, HttpStatus.OK);
    }
}