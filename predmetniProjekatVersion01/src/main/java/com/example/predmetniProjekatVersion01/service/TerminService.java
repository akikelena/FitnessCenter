package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import com.example.predmetniProjekatVersion01.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepository terminRepository;

    public Termin dodaj(Termin termin){
        Termin termin1 = this.terminRepository.save(termin);
        return termin1;
    }

    public void obrisi(Long id){
         this.terminRepository.deleteById(id);
    }

    public Termin izmeni(Termin termin){
        Termin termin1 = this.terminRepository.save(termin);
        return  termin1;
    }

    public List<Termin> findAll(){
        return this.terminRepository.findAll();
    }

    public Termin findOneById(Long id){
        return this.terminRepository.findOneById(id);
    }

    public Termin findOne(Long id) {
        return this.terminRepository.getOne(id);
    }

    public List<Termin> findByNaziv(String naziv){
        List<Termin> terminiNaziv = this.terminRepository.findAllByTreningNazivContaining(naziv);
        return terminiNaziv;
    }

    public List<Termin> findByOpis(String opis){
        List<Termin> terminiOpis = this.terminRepository.findAllByTreningOpisContaining(opis);
        return terminiOpis;
    }

    public List<Termin> findAllByTipTreninga(TipTreninga tipTreninga){
        List<Termin> terminiTip = this.terminRepository.findAllByTreningTipTreninga(tipTreninga);
        return terminiTip;
    }


    public List<Termin> findByCenaMax(double cena){
        List<Termin> terminiCenaLessEqual = this.terminRepository.findAllByCenaLessThanEqual(cena);
        return terminiCenaLessEqual;
    }

    public List<Termin> sortCena(){
        List<Termin> sortCena = this.terminRepository.findAllByOrderByCena();
        return sortCena;
    }

    public List<Termin> sortCenaDesc(){
        List<Termin> sortCenaDesc = this.terminRepository.findAllByOrderByCenaDesc();
        return  sortCenaDesc;
    }

    public List<Termin> sortVreme(){
        List<Termin> sortVreme = this.terminRepository.findAllByOrderByPocetakTermina();
        return sortVreme;
    }

    public List<Termin> sortVremeDesc(){
        List<Termin> sortVremeDesc = this.terminRepository.findAllByOrderByPocetakTerminaDesc();
        return sortVremeDesc;
    }

    public List<Termin> findAllVremeGreaterEqual(Date pocetakTermina){
        List<Termin> terminiVremeGreaterEqual = this.terminRepository.findAllByPocetakTerminaGreaterThanEqual(pocetakTermina);
        return terminiVremeGreaterEqual;
    }
    public List<Termin> findAllVremeLess(Date pocetakTermina){
        List<Termin> terminiVremeLess = this.terminRepository.findAllByPocetakTerminaLessThan(pocetakTermina);
        return terminiVremeLess;
    }



}
