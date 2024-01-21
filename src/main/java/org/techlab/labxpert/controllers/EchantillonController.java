package org.techlab.labxpert.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.techlab.labxpert.dtos.AnalyseDTO;
import org.techlab.labxpert.dtos.EchantillonDTO;
import org.techlab.labxpert.dtos.OutilDTO;
import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.entity.Echantillon;
import org.techlab.labxpert.entity.Outil;
import org.techlab.labxpert.service.I_Analyse;
import org.techlab.labxpert.service.I_Echantillon;
import org.techlab.labxpert.service.I_Outil;
import org.techlab.labxpert.service.I_Outil_Echantillon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/echantillon")
public class EchantillonController {

    @Autowired
    I_Echantillon i_echantillon;
    @Autowired
    I_Analyse i_analyse;
    @Autowired
    I_Outil_Echantillon i_outil_echantillon;
    @Autowired
    I_Outil i_outil;
    ModelMapper modelMapper=new ModelMapper();

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
        //echantillonDTO.setDeleted(true);
        Map<String,Boolean> response=new HashMap<>();
        if(i_echantillon.delEchantillhon(echantillonDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }
    @PostMapping
    EchantillonDTO addEchantillon( @RequestBody EchantillonDTO echantillondto){
        EchantillonDTO echantillonDTO=i_echantillon.addEchantillon(echantillondto);
        /*String uri="http://localhost:8080/api/v1/analyse/echantillon/"+echantillonDTO.getIdEchantillon();
        RestTemplate restTemplate=new RestTemplate();
        AnalyseDTO analyseDTO=restTemplate.getForObject(uri,AnalyseDTO.class);
        System.out.println(analyseDTO);*/
        AnalyseDTO analyseDTO=new AnalyseDTO();
        analyseDTO.setEchantillon(modelMapper.map(echantillonDTO, Echantillon.class));
        analyseDTO.setNomAnalyse(echantillonDTO.getTypeAnalyse());
        i_analyse.addAnalyse(analyseDTO);
        if(echantillondto.getOutilEchantillonList()!=null){
        echantillondto.getOutilEchantillonList().forEach(outilEchantillon -> {
            outilEchantillon.setOutil(modelMapper.map(i_outil.outilById(outilEchantillon.getOutil().getIdOutil()), Outil.class));
            outilEchantillon.setEchantillon(modelMapper.map(echantillonDTO, Echantillon.class));
            i_outil_echantillon.add(outilEchantillon);
            OutilDTO outilDTO=modelMapper.map(outilEchantillon.getOutil(),OutilDTO.class);
            outilDTO.setQuantite(outilDTO.getQuantite()-outilEchantillon.getQuantite());
            i_outil.modOutil(outilDTO);
        });
        }

        return  echantillonDTO;
    }

}
