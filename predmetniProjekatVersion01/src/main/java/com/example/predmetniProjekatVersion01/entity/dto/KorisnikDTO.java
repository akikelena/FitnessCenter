package com.example.predmetniProjekatVersion01.entity.dto;

import com.example.predmetniProjekatVersion01.entity.Uloga;

import java.util.Date;

public class KorisnikDTO {
    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String kontaktTelefon;
    private String email;
    private Date datumRodjenja;
    private Uloga uloga;
    private Boolean aktivan;

    public KorisnikDTO(){
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontaktTelefon = kontaktTelefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon){
        this.kontaktTelefon = kontaktTelefon;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Date getDatumRodjenja(){
        return  this.datumRodjenja;
    }

    public  void setDatumRodjenja(Date datumRodjenja){
        this.datumRodjenja = datumRodjenja;
    }

    public Uloga getUloga(){
        return  this.uloga;
    }

    public void setUloga(Uloga uloga){
        this.uloga = uloga;
    }

    public Boolean getAktivan(){
        return this.aktivan;
    }

    public  void setAktivan(Boolean aktivan){
        this.aktivan = aktivan;
    }
}
