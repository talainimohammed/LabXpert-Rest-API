package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.NormeDTO;
import org.techlab.labxpert.service.I_Norme;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/norme")
public class NormeController {

    @Autowired
    I_Norme i_norme;

    @GetMapping
    public List<NormeDTO> showAllNormes(){
        return i_norme.showNormes();
    }
    @PostMapping
    public ResponseEntity<NormeDTO> addNorme(@RequestBody NormeDTO normeDTO){
        NormeDTO normeDTO1=i_norme.addNorme(normeDTO);
        return new ResponseEntity<>(normeDTO1, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public HashMap<String,Boolean> delNorme(@PathVariable(value = "id") Long id){
        NormeDTO normeDTO=i_norme.getNormeById(id);
        normeDTO.setDeleted(Boolean.TRUE);
        HashMap<String,Boolean> response=new HashMap<>();
        if(i_norme.delNorme(normeDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }
}
