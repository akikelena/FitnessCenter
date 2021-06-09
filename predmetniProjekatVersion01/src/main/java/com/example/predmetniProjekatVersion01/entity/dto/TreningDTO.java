package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;


public class TreningDTO {

    private Long id;
    private String naziv;
    private String opis;
    private TipTreninga tipTreninga;
    private int trajanje;
    private int cena;

    public TreningDTO(){}

    public TreningDTO(Long id, String naziv, String opis, TipTreninga tipTreninga, int trajanje, int cena){
        this.id = id;
        this.naziv = naziv;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.cena = cena;
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis(){
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga(){
        return tipTreninga.toString();
    }

    public void setTipTreninga(TipTreninga tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
