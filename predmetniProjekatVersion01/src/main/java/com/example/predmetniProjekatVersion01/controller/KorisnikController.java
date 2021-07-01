package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.dto.KorisnikDTO;
import com.example.predmetniProjekatVersion01.entity.dto.LogInOutDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import com.example.predmetniProjekatVersion01.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private FitnessCentarService fitnessCentarService;

    // HOME
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    public String home(){
        return "index.html";
    }

    // Pronalazak specificnog korisnika po ID-u
    @GetMapping(value = "/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable Long id){
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();
        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikDTO.setLozinka(korisnik.getLozinka());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setKontaktTelefon(korisnik.getKontaktTelefon());
        korisnikDTO.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikDTO.setEmail(korisnik.getEmail());
        korisnikDTO.setUloga(korisnik.getUloga());
        korisnikDTO.setAktivan(korisnik.getAktivan());

        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

    // Brisanje korisnika
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> obrisiKorisnika(@PathVariable Long id){
        this.korisnikService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/approveRequest", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> approveTren(@RequestBody List<Long> listID){
        System.out.println(listID.toString());

        for(Long id: listID){
            Korisnik korisnik = korisnikService.findOne(id);

            korisnik.setAktivan(true);
            korisnikService.change(korisnik);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // LOGIN
    @PostMapping(value = "/login_page",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> login(@RequestBody LogInOutDTO logInOutDTO){

        Korisnik korisnik = korisnikService.login(logInOutDTO);

        if(korisnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(),
                korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                korisnik.getIme(), korisnik.getPrezime(),
                korisnik.getKontaktTelefon(), korisnik.getEmail(),
                korisnik.getDatumRodjenja(), korisnik.getUloga(),
                korisnik.getAktivan());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }

    // REGISTRACIJA - korisnika
    @PostMapping(value = "/register_page",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> registracija(@RequestBody KorisnikDTO korisnikDTO){

        Korisnik korisnik = korisnikService.registracija(korisnikDTO);

        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setAktivan(true);

        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }

    // REGISTRACIJA - trenera
}
