package org.techlab.labxpert.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.EchantillonDTO;
import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.service.I_Echantillon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/V2/Echantillon")

public class EchantillonController {

    @Autowired
    I_Echantillon i_echantillon;
    @GetMapping
    public List<EchantillonDTO> showEchantillons() {
        return i_echantillon.showEhantillon();
    }
    @GetMapping("/{id}")
    public ResponseEntity<EchantillonDTO> showEchantillonWithId(@PathVariable(value = "id") Long id) {
        EchantillonDTO echantillonDTO = i_echantillon.showEchantillonwithid(id);
        return ResponseEntity.ok().body(echantillonDTO);
    }
    @PutMapping
    public ResponseEntity<EchantillonDTO> modEchantillon(@RequestBody EchantillonDTO echantillonDTO) {
        EchantillonDTO modifiedEchantillon = i_echantillon.modEchantillon(echantillonDTO);
        return ResponseEntity.ok().body(modifiedEchantillon);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delUser(@PathVariable(value = "id") Long id ){
        EchantillonDTO echantillonDTO= i_echantillon.showEchantillonwithid( id);
        echantillonDTO.setDeleted(true);
        Map<String,Boolean> response=new HashMap<>();
        if(i_echantillon.delEchantillhon(echantillonDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }
    @PostMapping
    EchantillonDTO addEchantillon( @RequestBody EchantillonDTO echantillondto){
        return    i_echantillon.addEchantillon( echantillondto);



    }

}
