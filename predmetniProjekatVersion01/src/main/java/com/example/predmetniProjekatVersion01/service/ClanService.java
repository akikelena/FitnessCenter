package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Clan;

import java.util.List;

public interface ClanService {
    Clan findOne(Long id);
    List<Clan> findAll();
    Clan kreiraj(Clan clan) throws Exception;
    Clan save(Clan clan);
    void delete(Long id);
}
