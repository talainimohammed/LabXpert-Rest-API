package org.techlab.labxpert.service.serviceImp;


import org.modelmapper.ModelMapper;
import org.techlab.labxpert.dtos.UtilisateurDTO;
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

    ModelMapper modelMapper=new ModelMapper();
    @Override
    public UtilisateurDTO addUser(UtilisateurDTO userdto) {
        Utilisateur user=modelMapper.map(userdto,Utilisateur.class);
        return utilisateurRepository.save(user);
       // return user;
    }
    @Override
    public List<UtilisateurDTO> showUsers() {
        return utilisateurRepository.findAll();
        //return null;
    }

    @Override
    public UtilisateurDTO authentification(String username, String password) {
        return null;
    }

    @Override
    public UtilisateurDTO modUser(UtilisateurDTO userdto) {
        return null;
    }

    @Override
    public Boolean delUser(UtilisateurDTO userdto) {
        return null;
    }




}
