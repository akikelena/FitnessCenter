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
@Table(name = "TRENER")
public class Trener implements Serializable {
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

    @Column
    protected Boolean uklonjen;

    @Column(name = "prosecna_ocena")
    protected Double prosecnaOcena;

    /*
        treneri koji rade u tom fitnes centru
       "Vise trenera moze da radi u 1(postojecem) fitness centru"
       (veza 1:n), strana: n                                        */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar fitnessCentar;

    /*
     lista treninga koje trener drzi
     "1 trener moze drzati vise treninga"
     veza 1:n, strana: 1                     */
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Termin> lista_treninga = new HashSet<>();

    public Boolean isAktivan(){
        return  aktivan;
    }

    public Boolean isUklonjen(){
        return uklonjen;
    }

}
