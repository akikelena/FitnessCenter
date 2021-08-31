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

        List<Termin> termini = this.terminRepository.findAll();
        List<TerminDTO> terminiDTO = new ArrayList<>();
        for (Termin termin : termini) {
            TerminDTO terminDTO = new TerminDTO(
                    termin.getId(),
                    termin.getPocetakTermina(),
                    termin.getKrajTermina(),
                    termin.getTrajanjeTermina(),
                    termin.getCena(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga());

            if(!termin.getOtkazan()) {
                terminiDTO.add(terminDTO);
            }
        }
        if(pretragaDTO.isSve()) {
            return terminiDTO;
        } else {


            List<TerminDTO> terminiCena  = new ArrayList<>();
            for (TerminDTO termin : terminiDTO) {
                if(pretragaDTO.getMaxCena() >= termin.getCena()) {
                    terminiCena.add(termin);
                }
            }
            List<TerminDTO> terminiTrajanje  = new ArrayList<>();
            for (TerminDTO termin : terminiCena) {
                if(pretragaDTO.getMaxTrajanje() >= termin.getTrajanjeTermina()) {
                    terminiTrajanje.add(termin);
                }
            }
            List<TerminDTO> terminiDatum  = new ArrayList<>();
            for (TerminDTO termin : terminiTrajanje) {
                if(termin.getPocetakTermina().before(pretragaDTO.getDoDatuma())) {
                    terminiDatum.add(termin);
                }
            }
            List<TerminDTO> terminiNaziv = new ArrayList<>();
            if(pretragaDTO.getNaziv().equals("sve")) {
                for (TerminDTO termin : terminiDatum) {

                    terminiNaziv.add(termin);

                }
            } else {

                for (TerminDTO termin : terminiDatum) {
                    if(termin.getNaziv().equalsIgnoreCase(pretragaDTO.getNaziv())) {
                        terminiNaziv.add(termin);
                    }
                }
            }
            List<TerminDTO> terminiOpis = new ArrayList<>();
            if(pretragaDTO.getOpis().equals("sve")) {
                for (TerminDTO termin : terminiNaziv) {

                    terminiOpis.add(termin);

                }
            } else {

                for (TerminDTO termin : terminiNaziv) {
                    if(termin.getOpis().equalsIgnoreCase(pretragaDTO.getOpis())) {
                        terminiOpis.add(termin);
                    }
                }
            }

            List<TerminDTO> terminTip = new ArrayList<>();
            if(pretragaDTO.getTipTreninga().equals("sve")) {
                for (TerminDTO termin : terminiOpis) {

                    terminTip.add(termin);

                }
            } else {

                for (TerminDTO termin : terminiOpis) {
                    if(termin.getTipTreninga().equalsIgnoreCase(pretragaDTO.getTipTreninga())) {
                        terminTip.add(termin);
                    }
                }
            }

            return terminTip;
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
