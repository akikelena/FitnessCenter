package com.example.predmetniProjekatVersion01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADMIN")
public class Admin implements Serializable {

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

    @Column(name = "aktivan")
    protected Boolean aktivan;
}
