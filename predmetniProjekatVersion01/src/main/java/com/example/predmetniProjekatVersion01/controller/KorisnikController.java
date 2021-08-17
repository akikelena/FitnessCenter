package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Uloga;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;
import com.example.predmetniProjekatVersion01.entity.dto.KorisnikDTO;
import com.example.predmetniProjekatVersion01.entity.dto.LogInOutDTO;
import com.example.predmetniProjekatVersion01.entity.dto.RegTrenerDTO;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import com.example.predmetniProjekatVersion01.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
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


    // lista svih korisnika(kod brisanja korisnika - admin func)
    @GetMapping(value = "/KorisnikList",
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getAll(){

        List<Korisnik> korisnikList = korisnikService.findAll();
        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

            for(Korisnik korisnik: korisnikList){
                KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(),
                        korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                        korisnik.getIme(), korisnik.getPrezime(),
                        korisnik.getKontaktTelefon(), korisnik.getEmail(),
                        korisnik.getDatumRodjenja(), korisnik.getUloga(),
                        korisnik.aktivanStatus());

                korisnikDTOS.add(korisnikDTO);


            }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }

    // Brisanje korisnika
    @DeleteMapping(value = "/KorisnikList/brisanje/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity obrisiKorisnika(@PathVariable Long id){

        this.korisnikService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
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

    // Odobravanje zahteva trenera
    @PutMapping(value = "/odobri_trenera",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> approveTren(@RequestBody List<Long> listID){
        System.out.println(listID.toString());

        for(Long id: listID){
            Korisnik korisnik = korisnikService.findOne(id);

            korisnik.setAktivan(true);
            korisnikService.change(korisnik);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // LOGIN korisnika
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
                korisnik.aktivanStatus());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }

    // REGISTRACIJA - korisnika
    @PostMapping(value = "/register_page",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> registracija(@RequestBody KorisnikDTO korisnikDTO){

        Korisnik korisnik = korisnikService.registracija(korisnikDTO);

        korisnikDTO.setId(korisnik.getId());

        return new ResponseEntity<>(korisnikDTO, HttpStatus.CREATED);
    }

    // REGISTRACIJA - trenera
    @PostMapping(value = "/registracijaTrenera",
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegTrenerDTO> regTrenera(@RequestBody RegTrenerDTO regTrenerDTO){

        Korisnik korisnik = korisnikService.registracijaTrenera(regTrenerDTO);
        regTrenerDTO.setId(korisnik.getId());
        regTrenerDTO.setAktivan(true);

        return new ResponseEntity<>(regTrenerDTO, HttpStatus.CREATED);
    }

    // LISTA TRENERA
    @GetMapping(value = "/lista_trenera", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<KorisnikDTO>> listaTrenera(){

        List<Korisnik> korisnikList = korisnikService.findAll();
        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

            for(Korisnik korisnik: korisnikList){
                if(korisnik.getUloga() == Uloga.TRENER  && korisnik.aktivanStatus() == false ){
                    KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(),
                            korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                            korisnik.getIme(), korisnik.getPrezime(),
                            korisnik.getKontaktTelefon(), korisnik.getEmail(),
                            korisnik.getDatumRodjenja(), korisnik.getUloga(),
                            korisnik.aktivanStatus());

            korisnikDTOS.add(korisnikDTO);
                }
            }
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }

    // ODOBRAVANJE ZAHTEVA TRENERA
    @PutMapping(value = "/odobriZahtevTrenera",
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> odobriZahtevTrenera(@RequestBody List<Long> idList){
        System.out.println(idList.toString());

            for (Long id : idList){
                Optional<Korisnik> korisnik = Optional.ofNullable(korisnikService.findOne(id));
                    if(korisnik.isPresent()){
                        korisnik.get().setAktivan(true);

                        korisnikService.change(korisnik.get());
                }
            }
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    // Izmena korisnickih podataka
    @PutMapping(value = "/azurirajKorisnika/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> izmeniFitnessCentar(@PathVariable Long id, @RequestBody KorisnikDTO korisnikDTO) throws Exception{

        Optional<Korisnik> korisnikOptional = Optional.ofNullable(korisnikService.findOne(id));

        if(!korisnikOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Korisnik korisnik = new Korisnik(korisnikOptional.get().getId(),
                korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka(),
                korisnikDTO.getKontaktTelefon(), korisnikDTO.getEmail());


        korisnik = korisnikService.change(korisnik);
        korisnikDTO.setId(id);

        return new ResponseEntity<>(korisnikDTO, HttpStatus.ACCEPTED);

    }

}
