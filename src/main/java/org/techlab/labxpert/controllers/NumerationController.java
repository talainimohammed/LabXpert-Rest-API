package org.techlab.labxpert.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.AnalyseDTO;
import org.techlab.labxpert.dtos.NumerationDTO;
import org.techlab.labxpert.service.I_Analyse;
import org.techlab.labxpert.service.I_Numeration;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/numeration")
public class NumerationController {
    @Autowired
    I_Numeration i_numeration;
    @Autowired
    I_Analyse i_analyse;

    @GetMapping
    public ResponseEntity<List<NumerationDTO>> showNumerations(){
        List<NumerationDTO> numerationDTO=i_numeration.allNumeration();
        return new ResponseEntity<>(numerationDTO,HttpStatus.OK);
    }
    @GetMapping("/analyse/{id}")
    public ResponseEntity<List<NumerationDTO>> showNumerationsWithAnalyse(@PathVariable(value = "id") Long id){
        AnalyseDTO analyseDTO=i_analyse.showAnalyseWithId(id);
        List<NumerationDTO> numerationDTO=i_numeration.allNumerationWithAnalyse(analyseDTO);
        return  new ResponseEntity<>(numerationDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<NumerationDTO> addNumeration(@RequestBody @Valid NumerationDTO numerationDTO){
        NumerationDTO numerationDTO1=i_numeration.addNumeration(numerationDTO);
        return new ResponseEntity<>(numerationDTO1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<NumerationDTO> modNumeration(@RequestBody @Valid NumerationDTO numerationDTO){
        NumerationDTO numerationDTO1=i_numeration.modNumeration(numerationDTO);
        return new ResponseEntity<>(numerationDTO1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String,Boolean>> deleteNumeration(@PathVariable(value = "id") Long id){
        NumerationDTO numerationDTO=i_numeration.NumerationWithId(id);
        //numerationDTO.setDeleted(Boolean.TRUE);
        HashMap<String,Boolean> response=new HashMap<>();
        if(i_numeration.delNumeration(numerationDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
