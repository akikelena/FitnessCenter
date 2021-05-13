package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;

    @Column(unique = true)
    private String oznakaSale;

   /*  lista sala koje se nalaze u tom fitnes centru(veza 1:n)
       "U 1 fitness centru moze postojati vise sala"
       veza 1:n, strana: n
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar saleFC;

    // terminska lista treninga
    /*
        koji trening se odrzava u kom danu, po kojoj ceni
        n:n veza
        broj prijvaljenih clanova za taj trening


    @ManyToMany
    @JoinTable(name = "terminska_li",
                joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> terminska_lista = new HashSet<>(); */

    @Override
    public String toString() {
        return "Sala : " +
                            "ID =" + id + '\'' +
                            "Kapacitet =" + kapacitet + '\'' +
                            "Oznaka Sale ='" + oznakaSale + '\'' ;
    }
}
