package org.techlab.labxpert.service.serviceImp;


import org.techlab.labxpert.entity.Utilisateur;
import org.techlab.labxpert.repository.UtilisateurRepository;
import org.techlab.labxpert.service.I_Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = "com.labtech.labxpert")
public class UtilisateurServiceImp implements I_Utilisateur {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Override
    public Utilisateur addUser(Utilisateur user) {
        return utilisateurRepository.save(user);
       // return user;
    }

    @Override
    public Utilisateur modUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    @Override
    public Boolean delUser(Utilisateur user) {
        return null;
    }

    @Override
    public List<Utilisateur> showUsers() {
        return utilisateurRepository.findAll();
        //return null;
    }

    @Override
    public Utilisateur authentification(String username, String password) {
        return null;
    }
}
