package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.ReactifDTO;
import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.service.I_Reactif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/Reactif")

public class ReactifController {
    @Autowired
    I_Reactif i_reactif;
    @GetMapping
    public List allReactif(){
        List<ReactifDTO> listreactif=i_reactif.showReactif();
        return listreactif;
    }
    @GetMapping("{id}")
    public ReactifDTO showReactif(@PathVariable(value = "id") Long id_reactif){
        ReactifDTO reactif=i_reactif.showReactifwithid(( id_reactif));
        return reactif ;
    }
    @PostMapping
    public ResponseEntity<ReactifDTO> addReactif(@RequestBody ReactifDTO reactifDTO){
    ReactifDTO ReactifDTO1=i_reactif.addReactif(reactifDTO);
        return new ResponseEntity<>( ReactifDTO1, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<ReactifDTO> modRactif(@RequestBody ReactifDTO reactifDTO){
        ReactifDTO reactifDTO1  =i_reactif.modReactif(reactifDTO);
        return new ResponseEntity<>(reactifDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delReactif(@PathVariable(value = "id") Long id_reactif ){
        ReactifDTO reactifDTO=i_reactif.showReactifwithid(id_reactif);
        reactifDTO.setDeleted(true);
        Map<String,Boolean> response=new HashMap<>();
        if(i_reactif.delReactif(reactifDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }
}
