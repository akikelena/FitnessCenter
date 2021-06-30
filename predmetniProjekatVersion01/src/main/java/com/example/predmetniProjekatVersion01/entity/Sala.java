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
@Table(name = "SALA")
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kapacitet")
    private int kapacitet;

    @Column(name = "oznaka_sale", unique = true)
    private String oznakaSale;

   /*  lista sala koje se nalaze u tom fitnes centru(veza 1:n)
       "U 1 fitness centru moze postojati vise sala"
       veza 1:n, strana: n
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar fitnessCentar;

    /*
        terminska lista = trening(dan/cena) + broj prijavljenih clanova u terminu

     */
    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> termini = new HashSet<>();

    public Sala(Long id, int kapacitet, String oznakaSale) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public Sala(int kapacitet, String oznakaSale) {
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }
}

