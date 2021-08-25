package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Admin;
import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.LogInOutDTO;
import com.example.predmetniProjekatVersion01.service.AdminService;
import com.example.predmetniProjekatVersion01.service.ClanService;
import com.example.predmetniProjekatVersion01.service.TrenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/prijava")
public class LogInController {

    private final AdminService adminService;
    private final TrenerService trenerService;
    private final ClanService clanService;

    public LogInController(AdminService adminService,
                           TrenerService trenerService,
                           ClanService clanService){
        super();
        this.adminService = adminService;
        this.trenerService = trenerService;
        this.clanService = clanService;
    }

    @PostMapping(value = "/clan",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogInOutDTO> loginClan(@RequestBody LogInOutDTO prijavaInDTO) throws Exception {

        LogInOutDTO statusDTO = new LogInOutDTO(
                prijavaInDTO.getKorisnickoIme(),
                prijavaInDTO.getLozinka(),
                prijavaInDTO.getRola(),
                prijavaInDTO.getId(),
                false,
                false);
        List<Clan> sviClanovi = clanService.findAll();
        for (Clan clan : sviClanovi) {
            if(clan.getAktivan()) {

                if(clan.getKorisnickoIme().equalsIgnoreCase(statusDTO.getKorisnickoIme())) {

                    statusDTO.setKorimeprovera(true);
                    if(clan.getLozinka().equals(statusDTO.getLozinka())) {

                        statusDTO.setLozinkaprovera(true);
                        statusDTO.setId(clan.getId());
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    } else {

                        statusDTO.setLozinkaprovera(false);
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    }
                }
            }

        }
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/trener",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogInOutDTO> loginTrener(@RequestBody LogInOutDTO prijavaInDTO) throws Exception {

        LogInOutDTO statusDTO = new LogInOutDTO(
                prijavaInDTO.getKorisnickoIme(),
                prijavaInDTO.getLozinka(),
                prijavaInDTO.getRola(),
                prijavaInDTO.getId(),
                false,
                false);
        List<Trener> sviTreneri = trenerService.findAll();
        for (Trener trener : sviTreneri) {
            if(trener.isAktivan() && !trener.isUklonjen()) {
                if(trener.getKorisnickoIme().equalsIgnoreCase(statusDTO.getKorisnickoIme())) {
                    statusDTO.setKorimeprovera(true);
                    if(trener.getLozinka().equals(statusDTO.getLozinka())) {
                        statusDTO.setLozinkaprovera(true);
                        statusDTO.setId(trener.getId());
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    } else {
                        statusDTO.setLozinkaprovera(false);
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    }
                }
            }

        }
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }

    @PostMapping( value = "/admin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogInOutDTO> adminClan(@RequestBody LogInOutDTO prijavaInDTO) throws Exception {

        LogInOutDTO statusDTO = new LogInOutDTO(
                prijavaInDTO.getKorisnickoIme(),
                prijavaInDTO.getLozinka(),
                prijavaInDTO.getRola(),
                prijavaInDTO.getId(),
                false,
                false);
        List<Admin> sviAdmini = adminService.findAll();
        for (Admin admin : sviAdmini) {
            if(admin.getAktivan()) {
                if(admin.getKorisnickoIme().equalsIgnoreCase(statusDTO.getKorisnickoIme())) {
                    statusDTO.setKorimeprovera(true);
                    if(admin.getLozinka().equals(statusDTO.getLozinka())) {
                        statusDTO.setLozinkaprovera(true);
                        statusDTO.setId(admin.getId());
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    } else {
                        statusDTO.setLozinkaprovera(false);
                        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
                    }
                }
            }

        }
        return new ResponseEntity<>(statusDTO, HttpStatus.OK);
    }
}
