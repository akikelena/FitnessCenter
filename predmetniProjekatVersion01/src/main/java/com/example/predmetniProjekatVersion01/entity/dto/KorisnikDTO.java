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
public class KorisnikDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String kontaktTelefon;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;
    private Boolean aktivan;

    public KorisnikDTO(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String kontaktTelefon, String email, Date datumRodjenja, Uloga uloga) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
    }

    public boolean aktivanStatus(){
        return aktivan;
    }


}
