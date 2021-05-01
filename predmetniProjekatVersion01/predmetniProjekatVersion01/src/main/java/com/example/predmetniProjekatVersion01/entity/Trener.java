package com.example.predmetniProjekatVersion01.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Trener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double prosecnaOcena;

    // lista treninga koje on drzi


    @Override
    public String toString() {
        return "Trener : "  +
                                "ID = " + id + '\'' +
                                "Prosecna ocena = " + prosecnaOcena + '\'' ;
    }
}
