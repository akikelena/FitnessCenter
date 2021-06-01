package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return  korisnik;
    }

    public List<Korisnik> findAll(){
        List<Korisnik> korisnikList = this.korisnikRepository.findAll();
        return  korisnikList;
    }

    public Korisnik save(Korisnik korisnik){
        return this.korisnikRepository.save(korisnik);
    }
    public Korisnik izmeni(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }
    public  void  delete(Long id){
        this.korisnikRepository.deleteById(id);
    }
}
