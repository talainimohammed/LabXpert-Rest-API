package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.AnalyseDTO;
import org.techlab.labxpert.dtos.PlanificationDTO;
import org.techlab.labxpert.service.I_Analyse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analyse")
public class AnalyseController {
    @Autowired
    I_Analyse i_analyse;


    @GetMapping
    public List<AnalyseDTO> getanalyses(){
        List<AnalyseDTO> analyses=i_analyse.showAnalyses();
        return analyses;
    }
    @GetMapping("/{id}")
    public AnalyseDTO getanalyse(@PathVariable(value = "id") Long id){
        AnalyseDTO analyse=i_analyse.showAnalyseWithId(id);
        return analyse;
    }

    @PutMapping
    public AnalyseDTO updateAnalyse(@RequestBody AnalyseDTO analyseDTO){
        AnalyseDTO analyseDTO1=i_analyse.modAnalyse(analyseDTO);
        return  analyseDTO1;
    }
    @DeleteMapping("/{id}")
    public Map<String,Boolean> deleteAnalyse(@PathVariable(value = "id") Long id_analyse){
        AnalyseDTO analyseDTO=i_analyse.showAnalyseWithId(id_analyse);
        analyseDTO.setDeleted(Boolean.TRUE);
        Map<String,Boolean> response=new HashMap<>();
        if(i_analyse.delAnalyse(analyseDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }

    @PostMapping("/planification")
    public PlanificationDTO affectAnalyse(@RequestBody PlanificationDTO planificationDTO){
        planificationDTO=i_analyse.planifierAnalyse(planificationDTO);
        return planificationDTO;
    }
}
