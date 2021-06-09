package com.example.predmetniProjekatVersion01.entity.dto;

import java.util.Date;
import com.example.predmetniProjekatVersion01.entity.TipTreninga;

public class TerminDTO {

    private Long id;
    private Date pocetakTermina;
    private int brojPrijavljenihClanova;
    private double cena;

    private String naziv;
    private String opis;
    private TipTreninga tipTreninga;

    private String oznakaSale;

    public TerminDTO(){}

    public TerminDTO(Long id, Date pocetakTermina, int brojPrijavljenihClanova, double cena, String naziv, String opis, TipTreninga tipTreninga, String oznakaSale){
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.oznakaSale = oznakaSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(Date pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public int getBrojPrijavljenihClanova() {
        return brojPrijavljenihClanova;
    }

    public void setBrojPrijavljenihClanova(int brojPrijavljenihClanova) {
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
    }

    public TipTreninga getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
