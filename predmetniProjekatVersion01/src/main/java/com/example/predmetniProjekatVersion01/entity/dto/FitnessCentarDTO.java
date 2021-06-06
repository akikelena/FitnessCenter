package com.example.predmetniProjekatVersion01.entity.dto;

public class FitnessCentarDTO {
    private Long id;
    private String naziv;
    private String adresa;
    private String brTelCentrale;
    private String email;

    public FitnessCentarDTO(){

    }

    public FitnessCentarDTO(Long id, String naziv, String adresa, String brTelCentrale, String email){
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brTelCentrale = brTelCentrale;
        this.email = email;
    }

    public Long getId(){
        return  this.id;
    }

    public void  setId(Long id){
        this.id = id;
    }

    public String getNaziv(){
        return  naziv;
    }

    public void setNaziv(String naziv){
        this.naziv = naziv;
    }

    public String getAdresa(){
        return  this.adresa;
    }

    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    public String getBrTelCentrale(){
        return  this.brTelCentrale;
    }

    public void setBrTelCentrale(String brTelCentrale){
        this.brTelCentrale = brTelCentrale;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
