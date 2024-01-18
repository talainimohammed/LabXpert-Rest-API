package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.FournisseurDTO;
import org.techlab.labxpert.service.I_Fournisseur;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseur")
public class FournisseurController {

    @Autowired
    I_Fournisseur i_fournisseur;

    @GetMapping
    public ResponseEntity<List<FournisseurDTO>> showFournisseurs(){
        List<FournisseurDTO> fournisseurDTOS=i_fournisseur.showFournisseurs();
        return new ResponseEntity<>(fournisseurDTOS, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FournisseurDTO> getFournisseur(@PathVariable(value = "id") Long id_fournisseur){
        FournisseurDTO fournisseurDTO=i_fournisseur.getFournisseur(id_fournisseur);
        return new ResponseEntity<>(fournisseurDTO, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<FournisseurDTO> addFournisseur(@RequestBody FournisseurDTO fournisseurDTO){
        FournisseurDTO fournisseur=i_fournisseur.addFournisseur(fournisseurDTO);
        return new ResponseEntity<>(fournisseur, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<FournisseurDTO> modFournisseur(@RequestBody FournisseurDTO fournisseurDTO){
        FournisseurDTO fournisseur=i_fournisseur.modFournisseur(fournisseurDTO);
        return new ResponseEntity<>(fournisseur, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public HashMap<String,Boolean> delFournisseur(@PathVariable(value = "id") Long id_fournisseur){
        FournisseurDTO fournisseurDTO=i_fournisseur.getFournisseur(id_fournisseur);
        fournisseurDTO.setDeleted(Boolean.TRUE);
        HashMap<String,Boolean> response=new HashMap<>();
        if(i_fournisseur.delFournisseur(fournisseurDTO)){
            response.put("delete",Boolean.TRUE);
        }
        return response;
    }
}
