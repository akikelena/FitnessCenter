package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.entity.dto.TrenerDTO;
import com.example.predmetniProjekatVersion01.repository.TrenerRepository;
import com.example.predmetniProjekatVersion01.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository){
        this.trenerRepository = trenerRepository;
    }

    @Override
    public Trener findOne(Long id){
        Trener trener = this.trenerRepository.getOne(id);
        return  trener;
    }

    @Override
    public List<Trener> findAll(){
        List<Trener> trenerList = this.trenerRepository.findAll();
        return  trenerList;
    }

    @Override
    public List<TrenerDTO> findAktivne(){
        List<Trener> trenerList = this.trenerRepository.findAll();
        List<TrenerDTO> trenerDTOList = new ArrayList<>();

            for(Trener trener : trenerList){
                if(trener.isAktivan() && !trener.isUklonjen()){
                    TrenerDTO trenerDTO = new TrenerDTO(
                            trener.getId(),
                            trener.getKorisnickoIme(),
                            trener.getLozinka(),
                            trener.getIme(),
                            trener.getPrezime(),
                            trener.getEmail(),
                            trener.getDatumRodjenja(),
                            trener.getKontaktTelefon(),
                            trener.isAktivan(),
                            0,
                            trener.getFitnessCentar().getId()
                    );
                    trenerDTOList.add(trenerDTO);
                }
            }
            return  trenerDTOList;
    }

    @Override
    public List<TrenerDTO> findZahteveTrenera(){
        List<Trener> trenerList = this.trenerRepository.findAll();
        List<TrenerDTO> trenerDTOList = new ArrayList<>();

            for(Trener trener: trenerList){
                if(!trener.isAktivan() && !trener.isUklonjen()){
                    TrenerDTO trenerDTO = new TrenerDTO(
                            trener.getId(),
                            trener.getKorisnickoIme(),
                            trener.getLozinka(),
                            trener.getIme(),
                            trener.getPrezime(),
                            trener.getEmail(),
                            trener.getDatumRodjenja(),
                            trener.getKontaktTelefon(),
                            trener.isAktivan(),
                            0,
                            trener.getFitnessCentar().getId()
                    );
                    trenerDTOList.add(trenerDTO);
                }
            }
            return trenerDTOList;
    }

    @Override
    public Trener aktivirajTrenera(Long id) throws Exception{
        Trener azuriraj = this.trenerRepository.getOne(id);
        if(azuriraj == null){
            throw new Exception("Trener ne postoji u bazi!");
        }

        azuriraj.setAktivan(true);

        Trener cuvaj = this.trenerRepository.save(azuriraj);
        return cuvaj;
    }

    @Override
    public Trener kreiraj(Trener trener) throws Exception{
        if(trener.getId() != null){
            throw new Exception("Id mora biti null!");
        }

        Trener novi = this.trenerRepository.save(trener);
        return novi;
    }

    @Override
    public Trener logickoBrisanje(Long id) throws Exception{
        Trener azuriraj = this.trenerRepository.getOne(id);

        if(azuriraj == null){
            throw new Exception("Id mora biti null");
        }

        azuriraj.setUklonjen(true);

        Trener cuvaj = this.trenerRepository.save(azuriraj);
        return  cuvaj;
    }

    @Override
    public void save(Trener trener){
        this.trenerRepository.save(trener);
    }

    @Override
    public void delete(Long id){
        this.trenerRepository.deleteById(id);
    }

}
