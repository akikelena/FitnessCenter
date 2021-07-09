package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TerminDTO {

    private Long id;
    private Date pocetakTermina;
    private int brojPrijavljenihClanova;
    private double cena;
    private String naziv;
    private String opis;
    private TipTreninga tipTreninga;
    private String oznakaSale;

    public TerminDTO(Long id, String naziv, String opis, TipTreninga tipTreninga, String oznakaSale, Date pocetakTermina, double cena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.oznakaSale = oznakaSale;
        this.pocetakTermina = pocetakTermina;
        this.cena = cena;
    }
}
