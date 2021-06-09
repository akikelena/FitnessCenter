package com.example.predmetniProjekatVersion01.entity.dto;

import java.util.Date;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;

public class OcenaDTO {

    private int ocena;

    private String korisnickoIme;
    private String trenerPrezime;
    private String trenerIme;

    private String nazivTreninga;
    private TipTreninga tipTreninga;

    private Date pocetakTermina;

    public OcenaDTO(){}

    public OcenaDTO(String korisnickoIme, int ocena, String trenerIme, String  trenerPrezime, String nazivTreninga, TipTreninga tipTreninga, Date pocetakTermina){
        this.korisnickoIme = korisnickoIme;
        this.ocena = ocena;
        this.trenerIme = trenerIme;
        this.trenerPrezime = trenerPrezime;
        this.nazivTreninga = nazivTreninga;
        this.tipTreninga = tipTreninga;
        this.pocetakTermina = pocetakTermina;
    }

    public Date getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(Date pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }

    public String getTrenerIme() {
        return trenerIme;
    }

    public void setTrenerIme(String trenerIme) {
        this.trenerIme = trenerIme;
    }

    public String getTrenerPrezime() {
        return trenerPrezime;
    }

    public void setTrenerPrezime(String trenerPrezime) {
        this.trenerPrezime = trenerPrezime;
    }

    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }
}
