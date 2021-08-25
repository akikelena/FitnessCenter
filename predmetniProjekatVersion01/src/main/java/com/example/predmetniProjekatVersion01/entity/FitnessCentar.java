package com.example.predmetniProjekatVersion01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    private Boolean uklonjen;

    /* treneri koji rade u tom fitnes centru
       "U 1 fitnes centru moze da radi vise trenera"
        veza 1:n, strana: 1                              */
    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trener> treneriUFC = new HashSet<>();

    /* lista sala koje se nalaze u tom fitnes centru(veza 1:n)
       "U 1 fitness centru moze postojati vise sala"
       veza 1:n, strana: 1                                     */
    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> saleUFC = new HashSet<>();

    public FitnessCentar( String naziv, String adresa, String brTelCentrale, String email, Boolean uklonjen) {
        super();
        this.naziv = naziv;
        this.adresa = adresa;
        this.brTelCentrale = brTelCentrale;
        this.email = email;
        this.uklonjen = uklonjen;
    }
}
