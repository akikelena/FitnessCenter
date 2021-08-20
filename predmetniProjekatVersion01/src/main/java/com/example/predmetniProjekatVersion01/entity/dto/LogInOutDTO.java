package com.example.predmetniProjekatVersion01.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogInOutDTO {

    private String korisnickoIme;
    private String lozinka;

    private Integer uloga;
    private Long id;

    private boolean korimeprovera;
    private boolean lozinkaprovera;

    public boolean isKorimeprovera() {
        return korimeprovera;
    }

    public boolean isLozinkaprovera() {
        return lozinkaprovera;
    }
}
