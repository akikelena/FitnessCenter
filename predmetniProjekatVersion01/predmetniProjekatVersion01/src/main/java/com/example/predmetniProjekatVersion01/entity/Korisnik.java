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
public abstract class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "korisnicnko_ime", unique = true, nullable = false)
    protected String korisnickoIme;

    @Column(nullable = false)
    protected String lozinka;

    @Column(nullable = false)
    protected String ime;

    @Column(nullable = false)
    protected String prezime;

    @Column(unique = true, name = "kontakt_telefon")
    protected String kontaktTelefon;

    @Column(unique = true, nullable = false)
    protected String email;

    @Column(name = "datum_rodjenja")
    protected Date datumRodjenja;

    @Column
    @Enumerated(value = EnumType.STRING)
    protected Uloga uloga;

    @Column
    protected Boolean aktivan;

}
