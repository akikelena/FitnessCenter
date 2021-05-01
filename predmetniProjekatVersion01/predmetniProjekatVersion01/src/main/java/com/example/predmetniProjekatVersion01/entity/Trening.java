package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
//import java.util.HashSet;
//import java.util.Set;

@Setter
@Getter
@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tipTreninga;

    @Column
    private int trajanje;

    /*
    @ManyToMany(mappedBy = "odradjeniTreninzi")
    private Set<Clan> clanovi = new HashSet<>();

    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> clanovi_prijavljeni = new HashSet<>();    */

    //private Set <Trener> treneri = new HashSet<>();
    //private Set <Sala> sale = new HashSet<>();

    @Override
    public String toString() {
        return "Trening : : " +
                                "ID = " + id + '\'' +
                                "Naziv = " + naziv + '\'' +
                                "Opis = " + opis + '\'' +
                                "Tip treninga = " + tipTreninga + '\'' +
                                "Trajanje = " + trajanje + '\'';
    }
}