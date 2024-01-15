package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Fournisseur;
import org.techlab.labxpert.repository.FournisseurRepository;
import org.techlab.labxpert.service.I_Fournisseur;

import java.util.List;
@Service
public class FournisseurServiceImp implements I_Fournisseur {
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Override
    public Fournisseur addFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur modFournisseur(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Boolean delFournisseur(Fournisseur fournisseur) {
        return null;
    }

    @Override
    public List<Fournisseur> showFournisseurs() {
        return fournisseurRepository.findAll();
    }
}
