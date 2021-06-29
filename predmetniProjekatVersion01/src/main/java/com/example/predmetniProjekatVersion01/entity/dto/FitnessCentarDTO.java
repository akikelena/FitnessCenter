package com.example.predmetniProjekatVersion01.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FitnessCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String brTelCentrale;
    private String email;

}
