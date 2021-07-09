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

    @Column(name = "broj_prijavljenih_clanova")
    private int brojPrijavljenihClanova;

    @Column(name = "cena")
    private double cena;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sale;

    /*  lista odradjenih treninga
    Jedan clan moze odraditi vise treninga, ali i jednom treningu moze pristupiti vise clanova
    veza n:n
    @ManyToMany(mappedBy = "odradjeniTermini")
    private Set<Korisnik> clanovi_odradjeni = new HashSet<>();
     */

    /*  lista prijavljenih treninga
      Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
      veza n:n  */
    @ManyToMany(mappedBy = "prijavljeniTermini")
    private Set<Korisnik> clanovi_prijavljeni = new HashSet<>();

    public Termin(Long id, Date pocetakTermina, int brojPrijavljenihClanova, double cena, Sala sale, Trening trening, Set<Ocena> ocene) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.sale = sale;
        this.trening = trening;
        this.ocene = ocene;
    }


    public Termin(Long id, Date pocetakTermina, int brojPrijavljenihClanova, double cena, String naziv, String opis, TipTreninga tipTreninga, String oznakaSale) {
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;

    }

}