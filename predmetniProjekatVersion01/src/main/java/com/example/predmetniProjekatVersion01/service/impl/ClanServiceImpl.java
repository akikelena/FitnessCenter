package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Clan;
import com.example.predmetniProjekatVersion01.entity.dto.IzmenaProfila;
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

    @Override
    public Clan izmeni(Long idFC, IzmenaProfila izmenaProfila) throws Exception{
        Clan centarIzmenjen = this.clanRepository.getOne(idFC);

        if(centarIzmenjen == null){
            throw new Exception("Trener ne postoji u postojecoj bazi!");
        }

        if(!izmenaProfila.getKorisnickoIme().isBlank())
            centarIzmenjen.setKorisnickoIme(izmenaProfila.getKorisnickoIme());

        if (!izmenaProfila.getLozinka().isBlank())
            centarIzmenjen.setLozinka(izmenaProfila.getLozinka());

        if (!izmenaProfila.getIme().isBlank())
            centarIzmenjen.setIme(izmenaProfila.getIme());

        if (!izmenaProfila.getPrezime().isBlank())
            centarIzmenjen.setPrezime(izmenaProfila.getPrezime());

        if (!izmenaProfila.getKontaktTelefon().isBlank())
            centarIzmenjen.setKontaktTelefon(izmenaProfila.getKontaktTelefon());

        if (!izmenaProfila.getEmail().isBlank())
            centarIzmenjen.setEmail(izmenaProfila.getEmail());

        Clan centarCuvaj = this.clanRepository.save(centarIzmenjen);
        return centarCuvaj;
    }
}
