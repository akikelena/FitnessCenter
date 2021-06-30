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
@Table(name = "TRENING")
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @Column(name = "tip_treninga", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipTreninga tipTreninga;

    @Column(name = "trajanje", nullable = false)
    private int trajanje;

    /* lista treninga koje trener drzi
        "1 trener moze drzati vise treninga"
        veza 1:n, strana: n   */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Korisnik treninzi_koje_drzi;

    @OneToMany(mappedBy = "treninzi", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> termini = new HashSet<>();

    public Trening(Long id, String naziv, String opis, TipTreninga tipTreninga, int trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }
}