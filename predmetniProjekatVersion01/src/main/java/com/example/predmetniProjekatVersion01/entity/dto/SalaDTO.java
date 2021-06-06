package com.example.predmetniProjekatVersion01.entity.dto;

public class SalaDTO {

    private Long id;
    private int kapacitet;
    private String oznakaSale;

    public SalaDTO(){}

    public SalaDTO(Long id, int kapacitet, String oznakaSale){
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }
}
