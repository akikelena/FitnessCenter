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
public class OcenaDTO {

    private int ocena;

    private String korisnickoIme;
    private String trenerPrezime;
    private String trenerIme;

    private String nazivTreninga;
    private TipTreninga tipTreninga;

    private Date pocetakTermina;

}
