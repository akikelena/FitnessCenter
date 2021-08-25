package com.example.predmetniProjekatVersion01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TERMIN")
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pocetak_termina")
    private Date pocetakTermina;

    @Column(name = "kraj_termina")
    private Date krajTermina;

    @Column(name = "trajanje_termina", nullable = false)
    private int trajanjeTermina;

    @Column(name = "cena")
    private double cena;

    @Column
    private Boolean otkazan;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sale;

    /* lista termina koje trener drzi
        "1 trener moze drzati vise treninga"
        veza 1:n, strana: n   */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trener trener;

    /*  lista odradjenih treninga
    Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova
    veza n:n    */
    @ManyToMany(mappedBy = "odradjeniTermini")
    private Set<Clan> clanovi_odradjeni = new HashSet<>();

    @ManyToMany(mappedBy = "neodradjeniTermini")
    private Set<Clan> clanovi_neodradjeni = new HashSet<>();


}