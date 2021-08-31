package com.example.predmetniProjekatVersion01.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IzmenaProfila {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String email;
    private String kontaktTelefon;
    private Integer rola;

}
