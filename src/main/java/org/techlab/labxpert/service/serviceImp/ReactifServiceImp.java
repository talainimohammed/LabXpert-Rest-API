package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Reactif;
import org.techlab.labxpert.repository.ReactifRepository;
import org.techlab.labxpert.service.I_Reactif;

import java.util.List;
@Service
public class ReactifServiceImp implements I_Reactif {
    @Autowired
    ReactifRepository reactifRepository;
    @Override
    public Reactif addReactif(Reactif reactif) {
        return reactifRepository.save(reactif);
    }

    @Override
    public Reactif modReactif(Reactif reactif) {
        return reactifRepository.save(reactif);
    }

    @Override
    public Boolean delReactif(Reactif reactif) {
        return null;
    }

    @Override
    public List<Reactif> showReactifs() {
        return reactifRepository.findAll();
    }
}
