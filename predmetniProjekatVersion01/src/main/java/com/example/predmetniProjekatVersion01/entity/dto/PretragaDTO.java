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
public class PretragaDTO {

    private int maxCena;
    private int maxTrajanje;
    private String tipTreninga;

    private String naziv;
    private String opis;
    private Date doDatuma;

    private boolean sve;

    public boolean isSve() {
        return sve;
    }
}
