package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.entity.dto.ClanDTO;
import com.example.predmetniProjekatVersion01.entity.dto.IzmenaProfila;
import com.example.predmetniProjekatVersion01.service.ClanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clan")
public class ClanController {

    private final ClanService clanService;

    public ClanController (ClanService clanService){
        super();
        this.clanService = clanService;
    }

    @PostMapping(value = "/dodajClana",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> dodajClana(@RequestBody ClanDTO clanDTO) throws Exception {
        List<Clan> clanovi = clanService.findAll();
        for(Clan clan : clanovi) {
            if(clan.getKorisnickoIme().equalsIgnoreCase(clanDTO.getKorisnickoIme())) {
                ClanDTO newClanDTO = new ClanDTO(
                        Long.valueOf(1),
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        clan.getDatumRodjenja(),
                        "not created",
                        false,
                        1);
                return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
            }
            if(clan.getEmail().equalsIgnoreCase(clanDTO.getEmail())) {
                ClanDTO newClanDTO = new ClanDTO(
                        Long.valueOf(1),
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        clan.getDatumRodjenja(),
                        "not created",
                        false,
                        2);
                return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
            }
            if(clan.getKontaktTelefon().equalsIgnoreCase(clanDTO.getKontaktTelefon())) {
                ClanDTO newClanDTO = new ClanDTO(
                        Long.valueOf(1),
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        "not created",
                        clan.getDatumRodjenja(),
                        "not created",
                        false,
                        3);
                return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
            }

        }
        Clan clan = new Clan(
                clanDTO.getKorisnickoIme(),
                clanDTO.getIme(),
                clanDTO.getPrezime(),
                clanDTO.getLozinka(),
                clanDTO.getEmail(),
                clanDTO.getDatumRodjenja(),
                clanDTO.getKontaktTelefon(),
                clanDTO.getAktivan());

        Clan newClan = clanService.kreiraj(clan);

        ClanDTO newClanDTO = new ClanDTO(
                newClan.getId(),
                newClan.getKorisnickoIme(),
                newClan.getIme(),
                newClan.getPrezime(),
                newClan.getLozinka(),
                newClan.getEmail(),
                newClan.getDatumRodjenja(),
                newClan.getKontaktTelefon(),
                newClan.getAktivan(),
                0);

        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }
    @GetMapping(value = "/profil/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> getAktivne(@PathVariable Long id) {


        Clan clan = this.clanService.findOne(id);
        ClanDTO retVal = new ClanDTO(
                clan.getId(),
                clan.getKorisnickoIme(),
                clan.getIme(),
                clan.getPrezime(),
                "********",
                clan.getEmail(),
                clan.getDatumRodjenja(),
                clan.getKontaktTelefon(),
                clan.getAktivan(),
                clan.getNeodradjeniTermini().size());


        return new ResponseEntity<>(retVal, HttpStatus.OK);

    }

    @PostMapping(value = "/azurirajProfil/{idFC}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzmenaProfila> izmeniadmin(@PathVariable Long idFC, @RequestBody IzmenaProfila izmenaProfila) throws Exception{

        if(izmenaProfila.getRola() == 1){
            List<Clan> adminList = clanService.findAll();
            for(Clan clan: adminList){
                if(clan.getKorisnickoIme().equals(izmenaProfila.getKorisnickoIme())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            false,
                            2);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
                if(clan.getEmail().equals(izmenaProfila.getEmail())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            false,
                            3);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
            }
            Clan izmenjen = this.clanService.izmeni(idFC, izmenaProfila);
            IzmenaProfila povratni = new IzmenaProfila(
                    izmenjen.getId(),
                    izmenjen.getKorisnickoIme(),
                    "********",
                    izmenjen.getIme(),
                    izmenjen.getPrezime(),
                    izmenjen.getEmail(),
                    izmenjen.getKontaktTelefon(),
                    izmenjen.getAktivan(),
                    0);
            return new ResponseEntity<>(povratni, HttpStatus.OK);
        } else {
            IzmenaProfila adminDTO1 = new IzmenaProfila(
                    Long.valueOf(0),
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    false,
                    1);
            return new ResponseEntity<>(adminDTO1, HttpStatus.OK);
        }
    }


}
