package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.repository.ClanRepository;
import com.example.predmetniProjekatVersion01.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return clan;
    }

    @Override
    public List<Clan> findAll(){
        List<Clan> clanList = this.clanRepository.findAll();
        return clanList;
    }

    @Override
    public Clan kreiraj(Clan clan) throws Exception{
        if(clan.getId() != null){
            throw new Exception("Id mora biti null");
        }
        Clan noviClan = this.clanRepository.save(clan);
        return noviClan;
    }

    @Override
    public Clan save(Clan clan){
        Clan noviClan = this.clanRepository.save(clan);
        return noviClan;
    }

    @Override
    public void delete(Long id){
        this.clanRepository.deleteById(id);
    }
}
