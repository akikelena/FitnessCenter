package com.example.predmetniProjekatVersion01.entity.dto;

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
    private Date krajTermina;
    private Integer trajanjeTermina;
    private double cena;
    private String naziv;
    private String opis;
    private String tipTreninga;

}
