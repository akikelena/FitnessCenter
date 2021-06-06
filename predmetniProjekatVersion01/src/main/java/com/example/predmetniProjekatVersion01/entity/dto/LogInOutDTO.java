package com.example.predmetniProjekatVersion01.entity.dto;

public class LogInOutDTO {

    private String korisnickoIme;
    private String lozinka;


    public LogInOutDTO(){}

    public LogInOutDTO(String korisnickoIme, String lozinka){
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
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
}
