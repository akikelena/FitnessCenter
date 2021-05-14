package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Ocena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int ocena;

    // prosecna ocena trenera, veza 1:n, strana: n
    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termini;

    @ManyToMany(mappedBy = "ocene")
    private Set<Clan> ocenjeni_treninzi = new HashSet<>();


}
