package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Ocena;
import com.example.predmetniProjekatVersion01.entity.Termin;
import com.example.predmetniProjekatVersion01.entity.Trener;
import com.example.predmetniProjekatVersion01.repository.OcenaRepository;
import com.example.predmetniProjekatVersion01.repository.TrenerRepository;
import com.example.predmetniProjekatVersion01.service.OcenaService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OcenaServiceImpl implements OcenaService {

    private final OcenaRepository ocenaRepository;
    private final TrenerRepository trenerRepository;

    public OcenaServiceImpl(OcenaRepository ocenaRepository, TrenerRepository trenerRepository){
        super();
        this.ocenaRepository = ocenaRepository;
        this.trenerRepository = trenerRepository;
    }

    @Override
    public Double izracunajProsecnuOcenu(Long id){
        Trener trener = trenerRepository.getOne(id);

        Set<Termin> terminSet = trener.getLista_treninga();

        double suma = 0.0;
        int brojDatihOcena = 0;

            for(Termin termin: terminSet){
                Set<Ocena> ocenaSet = termin.getOcene();
                    for(Ocena ocena: ocenaSet){
                        suma += ocena.getOcena();
                        brojDatihOcena++;
                    }
            }

            if(brojDatihOcena == 0){
                return 0.0;
            } else {
                suma = suma/brojDatihOcena;
                return suma;
            }
    }

    @Override
    public Ocena kreiraj(Ocena ocena) throws Exception{
        if(ocena.getId() != null){
            throw  new Exception("Id mora biti null");
        }
        Ocena novaOcena = this.ocenaRepository.save(ocena);
        return novaOcena;
    }


}
