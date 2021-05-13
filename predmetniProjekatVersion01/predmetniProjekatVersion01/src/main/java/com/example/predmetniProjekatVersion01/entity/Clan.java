package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Clan extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*  lista odradjenih treninga
        Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova
        veza n:n                                                                                    */
    @ManyToMany
    @JoinTable(name = "odradjeni_treninzi",
                                            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
                                            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> odradjeniTreninzi = new HashSet<>();

    /*  lista prijavljenih treninga
        Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
        veza n:n                                                                                             */
    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
                joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();

    /* lista ocena za odradjene treninge
    private Set<double> lista_ocena = new HashSet<>();  */

    @Override
    public String toString() {
        return "Clan : " +
                "ID = " + id + '\'';
    }
}
