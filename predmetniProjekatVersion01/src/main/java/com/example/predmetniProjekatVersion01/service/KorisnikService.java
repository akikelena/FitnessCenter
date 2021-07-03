package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Uloga;
import com.example.predmetniProjekatVersion01.entity.dto.KorisnikDTO;
import com.example.predmetniProjekatVersion01.entity.dto.LogInOutDTO;
import com.example.predmetniProjekatVersion01.entity.dto.RegTrenerDTO;
import com.example.predmetniProjekatVersion01.repository.FCRepository;
import com.example.predmetniProjekatVersion01.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private FCRepository fcRepository;

    public Korisnik save(Korisnik korisnik){
        return this.korisnikRepository.save(korisnik);
    }
    public Korisnik change(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }
    public  void  delete(Long id){
        this.korisnikRepository.deleteById(id);
    }


    // DOBAVLJANJE KORISNIKA PREKO ID-A
    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return  korisnik;
    }

    // LISTA KORISNIKA
    public List<Korisnik> findAll(){
        List<Korisnik> korisnikList = this.korisnikRepository.findAll();
        return  korisnikList;
    }

    // PRIJAVA
    public Korisnik login(LogInOutDTO logInOutDTO){
        Korisnik korisnik = korisnikRepository.findKorisnikByKorisnickoIme(logInOutDTO.getKorisnickoIme());

        if(korisnik == null || korisnik.aktivanStatus() == false || !korisnik.getLozinka().equals(logInOutDTO.getLozinka())){
            return null;
        } else{
            return korisnik;
        }
    }

    // REGISTRACIJA
    public Korisnik registracija(KorisnikDTO korisnikDTO){

        if(korisnikDTO.getUloga() == Uloga.TRENER){
            korisnikDTO.setAktivan(false);
        }
        else if(korisnikDTO.getUloga() == Uloga.CLAN){
            korisnikDTO.setAktivan(true);
        }

        Korisnik korisnik = new Korisnik(korisnikDTO.getId(),
                korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka(),
                korisnikDTO.getIme(), korisnikDTO.getPrezime(),
                korisnikDTO.getKontaktTelefon(),
                korisnikDTO.getEmail(), korisnikDTO.getDatumRodjenja(),
                korisnikDTO.getUloga(), korisnikDTO.getAktivan(), korisnikDTO.aktivanStatus());

        korisnikRepository.save(korisnik);
        return korisnik;
    }

    // REGISTRACIJA TRENERA
    public Korisnik registracijaTrenera(RegTrenerDTO regTrenerDTO){

        Korisnik korisnik = new Korisnik(regTrenerDTO.getId(),
                regTrenerDTO.getKorisnickoIme(), regTrenerDTO.getLozinka(),
                regTrenerDTO.getIme(), regTrenerDTO.getPrezime(),
                regTrenerDTO.getKontaktTelefon(), regTrenerDTO.getEmail(),
                regTrenerDTO.getDatumRodjenja(), regTrenerDTO.getUloga(),
                regTrenerDTO.aktivanStatus());

        korisnik.setFitnessCentar(fcRepository.getOne(regTrenerDTO.getIdFC()));
        korisnikRepository.save(korisnik);

        return korisnik;
    }
}
