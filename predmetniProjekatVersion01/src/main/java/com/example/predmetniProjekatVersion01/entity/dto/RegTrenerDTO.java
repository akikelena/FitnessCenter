package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.Uloga;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegTrenerDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String kontaktTelefon;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;
    private Long idFC;
    boolean aktivan;
}
