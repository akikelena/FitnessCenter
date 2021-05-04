package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class FitnessCentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String brTelCentrale;

    @Column
    private String email;

    // raspored odrzavanja treninga + cena za svaki termin

    // 1. treneri koji rade u tom fitnes centru
    @OneToMany(mappedBy = "treneriFC", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneriUFC = new HashSet<>();

    // 2. lista sala koje se nalaze u tom fitnes centru
    @OneToMany(mappedBy = "saleFC", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> saleUFC = new HashSet<>();


    @Override
    public String toString() {
        return "FitnessCentar : " +
                                     "ID=" + id +
                                     "Naziv = " + naziv + '\'' +
                                     "Adresa = " + adresa + '\'' +
                                     "Broj Telefona Centrale="  + brTelCentrale + '\'' +
                                     "Email =" + email + '\'' ;
    }
}
