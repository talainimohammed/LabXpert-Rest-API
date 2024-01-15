package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.repository.AnalyseRepository;
import org.techlab.labxpert.service.I_Analyse;

import java.util.List;

@Service
public class AnalyseServiceImp implements I_Analyse {
    @Autowired
    AnalyseRepository analyseRepository;
    @Override
    public Analyse addAnalyse(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    @Override
    public Analyse modAnalyse(Analyse analyse) {
        return analyseRepository.save(analyse);
    }

    @Override
    public Boolean delAnalyse(Analyse analyse) {
        return null;
    }

    @Override
    public List<Analyse> showAnalyses() {
        return analyseRepository.findAll();
    }

    @Override
    public Analyse planifierAnalyse(Analyse analyse) {
        return null;
    }
}
