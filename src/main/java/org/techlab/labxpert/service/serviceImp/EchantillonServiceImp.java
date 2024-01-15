package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Echantillon;
import org.techlab.labxpert.repository.EchantillonRepository;
import org.techlab.labxpert.service.I_Echantillon;

import java.util.List;

@Service
public class EchantillonServiceImp implements I_Echantillon {
    @Autowired
    EchantillonRepository echantillonRepository;
    @Override
    public Echantillon addEchantillon(Echantillon echantillon) {

        return echantillonRepository.save(echantillon);
    }

    @Override
    public Echantillon modEchantillon(Echantillon echantillon) {
        return echantillonRepository.save(echantillon);
    }

    @Override
    public Boolean delEchantillon(Echantillon echantillon) {
        echantillonRepository.delete(echantillon);
        return true;
    }

    @Override
    public List<Echantillon> showEchantillons() {
        return echantillonRepository.findAll();
    }
}
