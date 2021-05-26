package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TERMIN")
public class Termin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int cena;

    @Column(name = "pocetak_termina")
    private Date pocetakTermina;


    @OneToMany(mappedBy = "termini", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening treninzi;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sale;

}
