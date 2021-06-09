package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
// @Table(name = "KORISNIK")
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public boolean aktivanStatus(){
        return aktivan;
    }

    /*
        treneri koji rade u tom fitnes centru
       "Vise trenera moze da radi u 1(postojecem) fitness centru"
       (veza 1:n), strana: n                                        */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar fitnessCentar;

    // prosecna ocena trenera, veza 1:n, strana: 1
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "odradjeni_termini",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> odradjeniTermini = new HashSet<>();

    /*  lista prijavljenih treninga
       Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
       veza n:n   */
    @ManyToMany
    @JoinTable(name = "prijavljeni_termini",
                joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> prijavljeniTermini = new HashSet<>();

    /*
      lista treninga koje trener drzi
      "1 trener moze drzati vise treninga"
      veza 1:n, strana: 1                     */
    @OneToMany(mappedBy = "treninzi_koje_drzi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> lista_treninga = new HashSet<>();



}