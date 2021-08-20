package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Trening;
import com.example.predmetniProjekatVersion01.entity.dto.TreningDTO;
import com.example.predmetniProjekatVersion01.repository.TreningRepository;
import com.example.predmetniProjekatVersion01.service.TreningService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreningServiceImpl implements TreningService {

    private final TreningRepository treningRepository;

    public TreningServiceImpl(TreningRepository treningRepository){
        super();
        this.treningRepository = treningRepository;
    }

    @Override
    public List<TreningDTO> findAll(){
        List<Trening> treningList = this.treningRepository.findAll();
        List<TreningDTO> treningDTOList = new ArrayList<>();

            for(Trening trening: treningList){
                TreningDTO treningDTO = new TreningDTO(
                        trening.getId(),
                        trening.getNaziv(),
                        trening.getOpis(),
                        trening.getTipTreninga()
                );
                treningDTOList.add(treningDTO);
            }
            return treningDTOList;
    }

    @Override
    public Trening pronadjiTrening(Long id){
        Trening trening = treningRepository.getOne(id);
        return trening;
    }
}
