package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String korisnickoIme;

    @Column(nullable = false)
    protected String lozinka;

    @Column(nullable = false)
    protected String ime;

    @Column(nullable = false)
    protected String prezime;

    @Column(unique = true)
    protected String kontakt_telefon;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column
    protected Date datumRodjenja;

    @Column
    protected Uloga uloga;

    @Column
    protected Boolean aktivan;

    @Override
    public String toString() {
        return "Korisnik : " +
                                "ID = " + id + '\'' +
                                "Korisnicko ime = " + korisnickoIme + '\'' +
                                "Lozinka = " + lozinka + '\'' +
                                "Ime = " + ime  + '\'' +
                                "Prezime = " + prezime + '\'' +
                                "Kontakt telefon = " + kontakt_telefon + '\'' +
                                "Email = " + email + '\'' +
                                "Datum rodjenja = " + datumRodjenja + '\'' +
                                "Uloga = " + uloga + '\'' +
                                "Aktivan = " + aktivan + '\'';
    }
}
