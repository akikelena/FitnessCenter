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

    public Termin findOne(Long id) {
        return this.terminRepository.getOne(id);
    }

    public List<Termin> findAllByNaziv(String naziv){
        List<Termin> terminiNaziv = this.terminRepository.findAllByTreninziNazivContaining(naziv);
        return terminiNaziv;
    }

    public List<Termin> findByOpis(String opis){
        List<Termin> terminiOpis = this.terminRepository.findAllByTreninziOpisContaining(opis);
        return terminiOpis;
    }

    public List<Termin> findAllByTipTreninga(TipTreninga tipTreninga){
        List<Termin> terminiTip = this.terminRepository.findAllByTreninziTipTreninga(tipTreninga);
        return terminiTip;
    }

    public List<Termin> findAllCenaGT(double cena){
        List<Termin> terminiCenaGreaterThan = this.terminRepository.findAllByCenaGreaterThan(cena);
        return terminiCenaGreaterThan;
    }

    public List<Termin> findAllCenaLess(double cena){
        List<Termin> terminiCenaLessEqual = this.terminRepository.findAllByCenaLessThanEqual(cena);
        return terminiCenaLessEqual;
    }

    public List<Termin> sortCena(){
        List<Termin> sortCena = this.terminRepository.findAllByOrderByCena();
        return sortCena;
    }

    public List<Termin> sortCenaAsc(){
        List<Termin> sortCenaAsc = this.terminRepository.findAllByOrderByCenaAsc();
        return sortCenaAsc;
    }

    public List<Termin> sortCenaDesc(){
        List<Termin> sortCenaDesc = this.terminRepository.findAllByOrderByCenaDesc();
        return  sortCenaDesc;
    }

    public List<Termin> sortVreme(){
        List<Termin> sortVreme = this.terminRepository.findAllByOrderByPocetakTermina();
        return sortVreme;
    }

    public List<Termin> sortVremeAsc(){
        List<Termin> sortVremeAsc = this.terminRepository.findAllByOrderByPocetakTerminaAsc();
        return sortVremeAsc;
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
