package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.dto.KorisnikDTO;
import com.example.predmetniProjekatVersion01.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    // HOME
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    public String home(){
        return "index.html";
    }

    // Pronalazak specificnog korisnika po ID-u
    @GetMapping(value = "/korisnici/{id}",
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

/*
    // Prijava
    @RequestMapping(value =  "/login_page", method = RequestMethod.GET)
    public String login(Model model){
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "login_page.html";
    }

    // Registracija
    @RequestMapping(value = "register_page.html", method = RequestMethod.GET)
    public String register(Model model){
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "register_page.html";
    }
 */
    // Pregled treniga u ponudi

    // Pretraga treninga po odredjenim kriterijumima

    // Visekriterijumska pretraga

    // Sortiranje termina, po vremenu ili ceni

}
