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

    @Override
    public void delete(Long id) {
        this.treningRepository.deleteById(id);

    }

    @Override
    public Trening findOne(Long id) {
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    @Override
    public Trening izmeni(Long id, Trening podaci)  throws Exception {
        Trening centarToUpdate = this.treningRepository.getOne(id);
        if (centarToUpdate == null) {
            throw new Exception("Trening ne postoji u bazi podataka");
        }
        if(!podaci.getNaziv().isBlank())
            centarToUpdate.setNaziv(podaci.getNaziv());
        if(!podaci.getOpis().isBlank())
            centarToUpdate.setOpis(podaci.getOpis());
        if(!podaci.getTipTreninga().isBlank())
            centarToUpdate.setTipTreninga(podaci.getTipTreninga());

        Trening saveFC = this.treningRepository.save(centarToUpdate);
        return saveFC;


    }
    @Override
    public Trening save(Trening trening) throws Exception{
        if(trening.getId() != null){
            throw new Exception("Id mora biti null");
        }
        Trening noviTrening = this.treningRepository.save(trening);
        return noviTrening;
    }


}
