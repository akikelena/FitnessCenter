package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.entity.Uloga;
import com.example.predmetniProjekatVersion01.entity.dto.KorisnikDTO;
import com.example.predmetniProjekatVersion01.entity.dto.LogInOutDTO;
import com.example.predmetniProjekatVersion01.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik korisnik){
        return this.korisnikRepository.save(korisnik);
    }
    public Korisnik change(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }
    public  void  delete(Long id){
        this.korisnikRepository.deleteById(id);
    }


    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return  korisnik;
    }

    public List<Korisnik> findAll(){
        List<Korisnik> korisnikList = this.korisnikRepository.findAll();
        return  korisnikList;
    }

    public Korisnik login(LogInOutDTO logInOutDTO){
        Korisnik korisnik = korisnikRepository.findKorisnikByKorisnickoIme(logInOutDTO.getKorisnickoIme());

        if(korisnik == null || korisnik.getAktivan() == false || !korisnik.getLozinka().equals(logInOutDTO.getLozinka())){
            return null;
        } else{
            return korisnik;
        }
    }

    /*
    public Korisnik registration(KorisnikDTO korisnikDTO){
        if(korisnikDTO.getUloga() == Uloga.TRENER){
            korisnikDTO.setAktivan(false);
        } else if(korisnikDTO.getUloga() == Uloga.CLAN){
            korisnikDTO.setAktivan(true);
        }
        Korisnik korisnik = new Korisnik(korisnikDTO.getId(), korisnikDTO.getKorisnickoIme(), korisnikDTO.getIme(),
                korisnikDTO.getLozinka(), korisnikDTO.getPrezime(), korisnikDTO.getUloga(), korisnikDTO.getAktivan());

        korisnikRepository.save(korisnik);

        return korisnik;
    }
        */
}
