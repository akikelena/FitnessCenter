package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;

    @Column
    private String oznakaSale;

    // terminska lista treninga
    /*
        koji trening se odrzava u kom danu, po kojoj ceni
        n:n veza
        broj prijvaljenih clanova za taj trening

     */

    @Override
    public String toString() {
        return "Sala : " +
                            "ID =" + id + '\'' +
                            "Kapacitet =" + kapacitet + '\'' +
                            "Oznaka Sale ='" + oznakaSale + '\'' ;
    }
}
