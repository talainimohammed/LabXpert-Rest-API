package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Norme;
import org.techlab.labxpert.repository.NormeRepository;
import org.techlab.labxpert.service.I_Norme;

import java.util.List;
@Service
public class NormeServiceImp implements I_Norme {

    @Autowired
    NormeRepository normeRepository;
    @Override
    public Norme addNorme(Norme norme) {
        return normeRepository.save(norme);
    }

    @Override
    public Norme modNorme(Norme norme) {
        return normeRepository.save(norme);
    }

    @Override
    public Boolean delNorme(Norme norme) {
        return null;
    }

    @Override
    public List<Norme> showNormes() {
        return normeRepository.findAll();
    }
}
