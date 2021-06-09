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
@Table(name = "FITNESS_CENTAR")
public class FitnessCentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "br_tel_centrale")
    private String brTelCentrale;

    @Column(name = "email")
    private String email;

    /* treneri koji rade u tom fitnes centru
       "U 1 fitnes centru moze da radi vise trenera"
        veza 1:n, strana: 1                              */
    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Korisnik> treneriUFC = new HashSet<>();

    /* lista sala koje se nalaze u tom fitnes centru(veza 1:n)
       "U 1 fitness centru moze postojati vise sala"
       veza 1:n, strana: 1                                     */
    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> saleUFC = new HashSet<>();

}
