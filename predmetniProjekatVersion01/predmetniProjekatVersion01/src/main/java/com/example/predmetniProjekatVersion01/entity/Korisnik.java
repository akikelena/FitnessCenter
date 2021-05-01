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
    private Long id;

    @Column(unique = true, nullable = false)
    private String korisnickoIme;

    @Column(unique = true, nullable = false)
    private String lozinka;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(unique = true)
    private Integer kontakt_telefon;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private Date datum_rodjenja;

    @Column
    private Uloga uloga;

    @Column
    private Boolean aktivan;


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
                                "Datum rodjenja = " + datum_rodjenja + '\'' +
                                "Uloga = " + uloga + '\'' +
                                "Aktivan = " + aktivan + '\'';
    }
}
