package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.dto.PretragaDTO;
import com.example.predmetniProjekatVersion01.entity.dto.TerminDTO;
import com.example.predmetniProjekatVersion01.repository.TerminRepository;
import com.example.predmetniProjekatVersion01.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository){
        this.terminRepository = terminRepository;
    }

    @Override
    public Termin findOne(Long id){
        Termin termin = this.terminRepository.getOne(id);
        return termin;
    }

    @Override
    public List<Termin> findAll(){
        List<Termin> terminList = this.terminRepository.findAll();
        return  terminList;
    }

    @Override
    public List<TerminDTO> findAllPretraga(PretragaDTO pretragaDTO){
        List<Termin> terminList = this.terminRepository.findAll();
        List<TerminDTO> terminDTOList = new ArrayList<>();

            for(Termin termin: terminList){
                TerminDTO terminDTO = new TerminDTO(
                        termin.getId(),
                        termin.getPocetakTermina(),
                        termin.getKrajTermina(),
                        termin.getTrajanjeTermina(),
                        termin.getCena(),
                        termin.getTrening().getNaziv(),
                        termin.getTrening().getOpis(),
                        termin.getTrening().getTipTreninga());

                if(!termin.getOtkazan()){
                    terminDTOList.add(terminDTO);
                }
            }
            if(pretragaDTO.isSve()){
                return terminDTOList;
            } else {

                List<TerminDTO> Cena = new ArrayList<>();
                    for(TerminDTO terminDTO: terminDTOList){
                        if(pretragaDTO.getMaxCena() >= terminDTO.getCena()){
                            Cena.add(terminDTO);
                        }
                    }
                List<TerminDTO> Trajanje = new ArrayList<>();
                    for(TerminDTO terminDTO:Cena ){
                        if(pretragaDTO.getMaxTrajanje() >= terminDTO.getTrajanjeTermina()){
                            Trajanje.add(terminDTO);
                        }
                    }
                List<TerminDTO> Datum = new ArrayList<>();
                    for(TerminDTO terminDTO: Trajanje){
                        if(terminDTO.getPocetakTermina().before(pretragaDTO.getDoDatuma())){
                            Datum.add(terminDTO);
                        }
                    }
                List<TerminDTO> Naziv = new ArrayList<>();
                    if(pretragaDTO.getNaziv().equals("sviParametri")){
                        for(TerminDTO terminDTO : Datum){
                            Naziv.add(terminDTO);
                        }
                    } else {
                        for(TerminDTO terminDTO: Datum){
                            if(terminDTO.getNaziv().equalsIgnoreCase(pretragaDTO.getNaziv())){
                                Naziv.add(terminDTO);
                            }
                        }
                    }
                List<TerminDTO> Opis = new ArrayList<>();
                    if(pretragaDTO.getOpis().equals("sviParametri")){
                        for(TerminDTO terminDTO: Naziv){
                            Opis.add(terminDTO);
                        }
                    } else {
                        for(TerminDTO terminDTO: Naziv){
                            if(terminDTO.getOpis().equalsIgnoreCase(pretragaDTO.getOpis())){
                                Opis.add(terminDTO);
                            }
                        }
                    }
                List<TerminDTO> Tip = new ArrayList<>();
                    if(pretragaDTO.getTipTreninga().equals("sviParametri")){
                        for(TerminDTO terminDTO: Opis){
                            Tip.add(terminDTO);
                        }
                    } else {
                        for(TerminDTO terminDTO: Opis){
                            if(terminDTO.getTipTreninga().equalsIgnoreCase(pretragaDTO.getTipTreninga())){
                                Tip.add(terminDTO);
                            }
                        }
                    }

                    return Tip;

            }
    }

    @Override
    public List<Termin> findAllById(Long id){
        List<Termin> terminList = this.terminRepository.findAll();
        List<Termin> idList = new ArrayList<>();
            for(Termin termin: terminList){
                if(termin.getTrener().getId() == id && !termin.getOtkazan()){
                    idList.add(termin);
                }
            }
        return idList;
    }

    @Override
    public Termin kreiraj(Termin termin) throws Exception{
        if(termin.getId() != null){
            throw new Exception("Id mora biti null");
        }

        Termin novi = this.terminRepository.save(termin);
        return novi;
    }

    @Override
    public Termin izmeni(Termin termin){
        Termin izmenjen = this.terminRepository.save(termin);
        return izmenjen;
    }

    @Override
    public Termin otkaziTermin(Long id){
        Termin otkazanTermin = this.terminRepository.getOne(id);
            otkazanTermin.setOtkazan(true);

        Termin povratna = this.terminRepository.save(otkazanTermin);
        return povratna;
    }

    @Override
    public void delete(Long id){
        this.terminRepository.deleteById(id);
    }
}
