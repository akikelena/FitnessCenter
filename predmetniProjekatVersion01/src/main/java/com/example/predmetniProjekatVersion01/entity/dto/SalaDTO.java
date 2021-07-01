package com.example.predmetniProjekatVersion01.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {

    private Long id;
    private int kapacitet;
    private String oznakaSale;
    private Long idFC;

}
