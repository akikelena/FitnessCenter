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
@Table(name = "CLAN")
public class Clan extends Korisnik implements Serializable {

    /*  lista odradjenih treninga
        Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova
        veza n:n  */
    @ManyToMany
    @JoinTable(name = "odradjeni_termini",
                                            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
                                            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Termin> odradjeniTermini = new HashSet<>();

    /*  lista prijavljenih treninga
        Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
        veza n:n                                                                                             */
    @ManyToMany
    @JoinTable(name = "prijavljeni_termini",
                joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> prijavljeniTermini = new HashSet<>();

    /* lista ocena za odradjene treninge
       Jedan clan moze oceniti vise treninga, ali i jedan trening moze oceniti vise clanova.
       veza n:n
     */
    @OneToMany(mappedBy = "clan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ocena> ocene = new HashSet<>();


}
