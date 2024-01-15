package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<UtilisateurDTO> addUser(@RequestBody UtilisateurDTO utilisateurDTO){
        UtilisateurDTO utilisateurDTO1=i_utilisateur.addUser(utilisateurDTO);
        return new ResponseEntity<>(utilisateurDTO1, HttpStatus.CREATED);
    }


}
