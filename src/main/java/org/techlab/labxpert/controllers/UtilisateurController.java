package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.entity.Utilisateur;
import org.techlab.labxpert.service.I_Utilisateur;
import org.techlab.labxpert.service.serviceImp.UtilisateurServiceImp;

import java.util.List;

@RestController
@RequestMapping("/api/v1/utilisateur")
public class UtilisateurController {
    @Autowired
    I_Utilisateur i_utilisateur;

    @GetMapping
    public List allUsers(){
        List<UtilisateurDTO> listusers=i_utilisateur.showUsers();
        return listusers;
    }
    @PostMapping
    public List addUser(){
        List<UtilisateurDTO> listusers=i_utilisateur.showUsers();
        return listusers;
    }


}
