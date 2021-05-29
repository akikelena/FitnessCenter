package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "KORISNIK")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "korisnicko_ime", unique = true, nullable = false)
    protected String korisnickoIme;

    @Column(name = "lozinka", nullable = false)
    protected String lozinka;

    @Column(name = "ime", nullable = false)
    protected String ime;

    @Column(name = "prezime", nullable = false)
    protected String prezime;

    @Column(name = "kontakt_telefon", unique = true)
    protected String kontaktTelefon;

    @Column(name = "email", unique = true, nullable = false)
    protected String email;

    @Column(name = "datum_rodjenja")
    protected Date datumRodjenja;

    @Column(name = "uloga")
    @Enumerated(value = EnumType.STRING)
    protected Uloga uloga;

    @Column(name = "aktivan")
    protected Boolean aktivan;

}