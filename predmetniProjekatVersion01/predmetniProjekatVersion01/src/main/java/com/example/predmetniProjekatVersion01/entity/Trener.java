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
public class Trener extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double prosecnaOcena;

    /*
        lista treninga koje trener drzi
        "1 trener moze drzati vise treninga"
        veza 1:n, strana: 1                     */
    @OneToMany(mappedBy = "treninzi_koje_drzi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> lista_treninga = new HashSet<>();

    /*
        treneri koji rade u tom fitnes centru
       "Vise trenera moze da radi u 1(postojecem) fitness centru"
       (veza 1:n), strana: n                                        */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar treneriFC;

    @Override
    public String toString() {
        return "Trener : "  +
                                "ID = " + id + '\'' +
                                "Prosecna ocena = " + prosecnaOcena + '\'' ;
    }
}
