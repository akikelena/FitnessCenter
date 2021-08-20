package com.example.predmetniProjekatVersion01.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClanDTO {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private String datumRodjenja;
    private String kontaktTelefon;
    private Boolean aktivan;

    private Integer retVal;

}
