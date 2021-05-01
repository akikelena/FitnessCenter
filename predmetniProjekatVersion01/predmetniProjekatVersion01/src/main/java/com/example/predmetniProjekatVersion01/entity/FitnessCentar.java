package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    // treneri koji rade u tom fitnes centru
    // lista sala koje se nalaze u tom fitnes centru
    // raspored odrzavanja treninga + cena za svaki termin


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
