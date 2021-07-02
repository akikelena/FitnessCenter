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
    private Date pocetakTerminaDatum;
    private int brojPrijavljenihClanova;
    private double cena;
    private String naziv;
    private String opis;
    private TipTreninga tipTreninga;
    private String oznakaSale;
}
