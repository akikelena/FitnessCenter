package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;

import java.util.Date;

public class IzabraniTerminDTO {

    private Long id;

    private Date pocetakTermina;
    private int brojPrijavljenihClanova;
    private double cena;
    private TipTreninga tipTreninga;
    private String naziv;
    private String opis;

    private String oznakaSale;
    private int kapacitet;


    public IzabraniTerminDTO(Long id, Date pocetakTermina, int brojPrijavljenihClanova, double cena, TipTreninga tipTreninga, String naziv, String opis, String oznakaSale, int kapacitet) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.tipTreninga = tipTreninga;
        this.naziv = naziv;
        this.opis = opis;
        this.oznakaSale = oznakaSale;
        this.kapacitet = kapacitet;

    }

    public IzabraniTerminDTO(Long id, Date pocetakTermina, double cena, String naziv, String opis, TipTreninga tipTreninga, String oznakaSale) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.cena = cena;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.oznakaSale = oznakaSale;
    }
}
