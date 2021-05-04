package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double prosecnaOcena;

       /* 1. lista treninga koje on drzi
       2. prosecna ocena trenera
     */

    // jedna strana veze 1:n
    @OneToMany(mappedBy = "trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> lista_treninga = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar trenFC;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar trenFCs;


    @Override
    public String toString() {
        return "Trener : "  +
                                "ID = " + id + '\'' +
                                "Prosecna ocena = " + prosecnaOcena + '\'' ;
    }
}
