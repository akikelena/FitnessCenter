package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.entity.dto.FitnessCentarDTO;
import com.example.predmetniProjekatVersion01.repository.FCRepository;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class FitnessCentarServiceImpl implements FitnessCentarService {

    private final FCRepository fcRepository;

    @Autowired
    public FitnessCentarServiceImpl(FCRepository fcRepository){
        this.fcRepository = fcRepository;
    }

    @Override
    public List<FitnessCentar> findAll(){
        List<FitnessCentar> fitnessCentars = this.fcRepository.findAll();
        return fitnessCentars;
    }

    @Override
    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar = this.fcRepository.getOne(id);
        return fitnessCentar;
    }

    @Override
    public List<FitnessCentarDTO> findSpecCentre(){
        List<FitnessCentar> fitnessCentars = this.fcRepository.findAll();
        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

            for(FitnessCentar fitnessCentar: fitnessCentars){
                if(!fitnessCentar.getUklonjen()){
                    FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(),
                            fitnessCentar.getNaziv(), fitnessCentar.getAdresa(), fitnessCentar.getBrTelCentrale(),
                            fitnessCentar.getEmail(), 0);
                    fitnessCentarDTOS.add(fitnessCentarDTO);
                }
            }

            return fitnessCentarDTOS;
    }

    @Override
    public FitnessCentar izmeni(Long id, FitnessCentarDTO data) throws Exception{
        FitnessCentar centarIzmenjen = this.fcRepository.getOne(id);

            if(centarIzmenjen == null){
                throw new Exception("Trener ne postoji u postojecoj bazi!");
            }

            if(!data.getNaziv().isBlank())
                centarIzmenjen.setNaziv(data.getNaziv());

            if (!data.getAdresa().isBlank())
                centarIzmenjen.setAdresa(data.getAdresa());

            if (!data.getBrTelCentrale().isBlank())
                centarIzmenjen.setBrTelCentrale(data.getBrTelCentrale());

            if (!data.getEmail().isBlank())
                centarIzmenjen.setEmail(data.getEmail());

            FitnessCentar centarCuvaj = this.fcRepository.save(centarIzmenjen);
            return centarCuvaj;
    }

    @Override
    public FitnessCentar saveOrCreate(FitnessCentar fitnessCentar) throws Exception{
        if(fitnessCentar.getId() != null){
            throw new Exception("Id mora biti null!");
        }
        FitnessCentar noviFC = this.fcRepository.save(fitnessCentar);
        return  noviFC;
    }

    @Override
    public void  delete(Long id){
        this.fcRepository.deleteById(id);
    }


}
