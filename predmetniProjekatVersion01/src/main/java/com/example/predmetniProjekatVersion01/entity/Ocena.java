package com.example.predmetniProjekatVersion01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OCENA")
public class Ocena implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int ocena;

    // prosecna ocena trenera, veza 1:n, strana: n
    @ManyToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

}
