package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.TipTreninga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TreningDTO {

    private Long id;
    private String naziv;
    private String opis;
    private TipTreninga tipTreninga;
    private int trajanje;
}
