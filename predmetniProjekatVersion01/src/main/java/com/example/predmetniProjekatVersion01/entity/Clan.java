package com.example.predmetniProjekatVersion01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CLAN")
public class Clan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "korisnicko_ime", unique = true, nullable = false)
    protected String korisnickoIme;

    @Column(name = "lozinka", nullable = false)
    protected String lozinka;

    @Column(name = "ime", nullable = false)
    protected String ime;

    @Column(name = "prezime", nullable = false)
    protected String prezime;

    @Column(name = "kontakt_telefon", unique = true)
    protected String kontaktTelefon;

    @Column(name = "email", unique = true, nullable = false)
    protected String email;

    @Column(name = "datum_rodjenja")
    protected Date datumRodjenja;

    @Column(name = "aktivan")
    protected Boolean aktivan;


    // prosecna ocena trenera, veza 1:n, strana: 1
    @OneToMany(mappedBy = "korisnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ocena> ocene = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "odradjeni_termini",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> odradjeniTermini = new HashSet<>();


    /*  lista prijavljenih treninga
       Jedan clan moze se prijaviti za VISE treninga, ali i jednom treningu moze pristupiti vise clanova
       veza n:n   */
    @ManyToMany
    @JoinTable(name = "prijavljeni",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> prijavljeniTermini = new HashSet<>();
}
