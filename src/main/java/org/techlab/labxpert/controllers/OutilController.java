package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.OutilDTO;
import org.techlab.labxpert.service.I_Outil;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/outil")
public class OutilController {
    @Autowired
    I_Outil i_outil;

    @GetMapping
    public ResponseEntity<List<OutilDTO>> allOutils(){
        List<OutilDTO> outilDTOS=i_outil.allOutils();
        return new ResponseEntity<>(outilDTOS, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<OutilDTO> addOutil(@RequestBody OutilDTO outilDTO){
        OutilDTO outiladded=i_outil.addOutil(outilDTO);
        return new ResponseEntity<>(outiladded, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<OutilDTO> modOutil(@RequestBody OutilDTO outilDTO){
        OutilDTO outilupdated=i_outil.modOutil(outilDTO);
        return new ResponseEntity<>(outilupdated, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HashMap<String,Boolean> delOutil(@PathVariable(value = "id") Long id_outil){
        OutilDTO outilDTO=i_outil.outilById(id_outil);
        outilDTO.setDeleted(Boolean.TRUE);
        HashMap<String,Boolean> response=new HashMap<>();
        if(i_outil.delOutil(outilDTO)){
            response.put("delete",Boolean.TRUE);
        }
        return response;
    }
}