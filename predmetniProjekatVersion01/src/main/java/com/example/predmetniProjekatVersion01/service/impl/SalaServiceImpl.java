package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Sala;
import com.example.predmetniProjekatVersion01.entity.dto.SalaDTO;
import com.example.predmetniProjekatVersion01.repository.SalaRepository;
import com.example.predmetniProjekatVersion01.repository.TrenerRepository;
import com.example.predmetniProjekatVersion01.service.SalaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;
    private final TrenerRepository trenerRepository;

    public SalaServiceImpl(SalaRepository salaRepository, TrenerRepository trenerRepository){
        super();

        this.salaRepository = salaRepository;
        this.trenerRepository = trenerRepository;
    }

    public Sala saveAndCreate(Sala sala) throws Exception{
        if(sala.getId() != null){
            throw new Exception("Id mora biti null!");
        }
        Sala novaSala = this.salaRepository.save(sala);
        return novaSala;
    }

    public  void delete(Long id){
        this.salaRepository.deleteById(id);
    }

    @Override
    public Sala logickoBrisanje(Long id) throws Exception{
        Sala izmenjena = this.salaRepository.getOne(id);

            if(izmenjena == null){
                throw  new Exception("Sala ne postoji u bazi!");
            }

            izmenjena.setSalaSeKoristi(false);

            Sala sacuvajSalu = this.salaRepository.save(izmenjena);
            return sacuvajSalu;
    }

    public Sala findOne(Long id){
        Sala sala = this.salaRepository.getOne(id);
        return  sala;
    }

    public List<Sala> findAll(){
        List<Sala> salaList = this.salaRepository.findAll();
        return  salaList;
    }

    public Sala izmeni(Sala sala){
        Sala cuvajSalu = this.salaRepository.save(sala);
        return  cuvajSalu;
    }

    public List<SalaDTO> findTrenutne(Long id){
        List<Sala> salaList = this.salaRepository.findAll();
        List<SalaDTO> salaDTOList = new ArrayList<>();

            for(Sala sala: salaList){
                if(sala.getSalaSeKoristi() && this.trenerRepository.getOne(id).getFitnessCentar().getId() == sala.getFitnessCentar().getId()){
                    SalaDTO salaDTO = new SalaDTO(
                            sala.getId(),
                            sala.getOznakaSale(),
                            sala.getKapacitet(),
                            sala.getFitnessCentar().getId());
                    salaDTOList.add(salaDTO);
                }
            }
            return salaDTOList;
    }
}
