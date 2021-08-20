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
public class TrenerDTO {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private Date datumRodjenja;
    private String kontaktTelefon;
    private Boolean aktivan;

    private Double prosecnaOcena;
    private Integer retVal;
    private Long idFC;

    public TrenerDTO(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String email, Date datumRodjenja, String kontaktTelefon, Boolean aktivan, Integer retVal, Long idFC) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.kontaktTelefon = kontaktTelefon;
        this.aktivan = aktivan;
        this.retVal = retVal;
        this.idFC = idFC;
    }
}
