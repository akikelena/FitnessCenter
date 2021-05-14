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
public class FitnessCentar implements Serializable {

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

    /* treneri koji rade u tom fitnes centru
       "U 1 fitnes centru moze da radi vise trenera"
        veza 1:n, strana: 1                              */
    @OneToMany(mappedBy = "treneriFC", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneriUFC = new HashSet<>();

    /* lista sala koje se nalaze u tom fitnes centru(veza 1:n)
       "U 1 fitness centru moze postojati vise sala"
       veza 1:n, strana: 1                                     */
    @OneToMany(mappedBy = "saleFC", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> saleUFC = new HashSet<>();

}
