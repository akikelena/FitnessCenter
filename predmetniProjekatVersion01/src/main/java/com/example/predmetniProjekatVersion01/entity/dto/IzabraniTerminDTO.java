package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;

import java.util.Date;

public class IzabraniTerminDTO {

    private Long id;
    private Date pocetakTermina;
    private double cena;
    private TipTreninga tipTreninga;
    private String naziv;
    private String opis;
    private String oznakaSale;
    private int trajanje;

    public IzabraniTerminDTO(Long id, Date pocetakTermina, double cena, TipTreninga tipTreninga, String naziv, String opis, int trajanje, String oznakaSale) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.cena = cena;
        this.tipTreninga = tipTreninga;
        this.naziv = naziv;
        this.opis = opis;
        this.trajanje = trajanje;
        this.oznakaSale = oznakaSale;
    }
}
