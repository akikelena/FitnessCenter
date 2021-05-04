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
public class Clan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        1. lista odradjenih treninga
        2. lista prijavljenih, neodradjenih treninga
        3. lista ocena za odradjene treninge
     */

    /*
        Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova,
        stoga se formira veza ManyToMany.
     */
    /* @ManyToMany
    @JoinTable(name = "odredjeni_treninzi",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> odradjeniTreninzi = new HashSet<>();   */

    /*
        Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti
        vise clanova, te ce veza biti ManyToMany.
     */

    /*
    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
                joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>(); */

    /* lista ocena za odradjene treninge
    private Set<double> lista_ocena = new HashSet<>();  */

    @Override
    public String toString() {
        return "Clan : " +
                "ID = " + id + '\'';
    }
}
