package com.example.predmetniProjekatVersion01.entity.dto;

import java.util.Date;

public class TerminDTO {

    private Long id;
    private Date pocetakTermina;
    private int brojPrijavljenihClanova;

    private TreningDTO treningDTO;
    private SalaDTO salaDTO;

    public TerminDTO(){}

    public TerminDTO(Long id, Date pocetakTermina, int brojPrijavljenihClanova, TreningDTO treningDTO, SalaDTO salaDTO){
        this.id = id;
        this.pocetakTermina = pocetakTermina;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.treningDTO = treningDTO;
        this.salaDTO = salaDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPocetakTermina() {
        return pocetakTermina;
    }

    public void setPocetakTermina(Date pocetakTermina) {
        this.pocetakTermina = pocetakTermina;
    }

    public int getBrojPrijavljenihClanova() {
        return brojPrijavljenihClanova;
    }

    public void setBrojPrijavljenihClanova(int brojPrijavljenihClanova) {
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
    }

    public TreningDTO getTreningDTO() {
        return treningDTO;
    }

    public void setTreningDTO(TreningDTO treningDTO) {
        this.treningDTO = treningDTO;
    }

    public SalaDTO getSalaDTO() {
        return salaDTO;
    }

    public void setSalaDTO(SalaDTO salaDTO) {
        this.salaDTO = salaDTO;
    }
}
