package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Set;

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
    private TipTreninga tipTreninga;

    @Column
    private int trajanje;

    /*
         lista treninga koje trener drzi
        "1 trener moze drzati vise treninga"
        veza 1:n, strana: n                    */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trener treninzi_koje_drzi;

    /*  lista odradjenih treninga
        Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova
        veza n:n                                                                                    */
    @ManyToMany(mappedBy = "odradjeniTreninzi")
    private Set<Clan> clanovi_odradjeni = new HashSet<>();

    /*  lista prijavljenih treninga
      Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
      veza n:n                                                                                             */
    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> clanovi_prijavljeni = new HashSet<>();

    /*
        @ManyToMany(mappedBy = "terminska_lista")
    private Set<Sala> sale_terminska = new HashSet<>();
     */

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