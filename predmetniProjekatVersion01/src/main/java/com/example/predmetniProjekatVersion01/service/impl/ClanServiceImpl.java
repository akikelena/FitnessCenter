package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.repository.ClanRepository;
import com.example.predmetniProjekatVersion01.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanServiceImpl implements ClanService {

    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository){
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan findOne(Long id){
        Clan clan = this.clanRepository.getOne(id);
        return
    }
}
