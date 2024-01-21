package org.techlab.labxpert.controllers;

import net.sf.jasperreports.engine.JRException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.AnalyseDTO;
import org.techlab.labxpert.dtos.EchantillonDTO;
import org.techlab.labxpert.dtos.PlanificationDTO;
import org.techlab.labxpert.entity.Echantillon;
import org.techlab.labxpert.service.I_Analyse;
import org.techlab.labxpert.service.I_Echantillon;
import org.techlab.labxpert.service.I_Rapport;
import org.techlab.labxpert.service.serviceImp.ResultRepport;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/analyse")
public class AnalyseController {
    @Autowired
    I_Analyse i_analyse;
    @Autowired
    I_Echantillon i_echantillon;
    @Autowired
    I_Rapport i_rapport;

    ModelMapper modelMapper=new ModelMapper();
    @GetMapping
    public ResponseEntity<List<AnalyseDTO>> getanalyses(){
        List<AnalyseDTO> analyses=i_analyse.showAnalyses();
        return new ResponseEntity<>(analyses,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnalyseDTO> getanalyse(@PathVariable(value = "id") Long id){
        AnalyseDTO analyse=i_analyse.showAnalyseWithId(id);
        return new ResponseEntity<>(analyse,HttpStatus.OK);
    }
    @GetMapping("/echantillon/{id}")
    public ResponseEntity<AnalyseDTO> addAnalyse(@PathVariable(value = "id") Long id_echantillong){
        EchantillonDTO echantillonDTO=i_echantillon.showEchantillonwithid(id_echantillong);
        AnalyseDTO analyseDTO=new AnalyseDTO();
        analyseDTO.setEchantillon(modelMapper.map(echantillonDTO, Echantillon.class));
        analyseDTO.setNomAnalyse(echantillonDTO.getTypeAnalyse());
        analyseDTO=i_analyse.addAnalyse(analyseDTO);
        return new ResponseEntity<>(analyseDTO,HttpStatus.CREATED);
    }
    @GetMapping("/pdf/{id}")
    public ResponseEntity<Resource> getpdf(@PathVariable(value = "id") Long id_Analyse) throws JRException, FileNotFoundException, ParseException {
        byte[] reportContent=i_rapport.exportReport(id_Analyse);
        ByteArrayResource resource = new ByteArrayResource(reportContent);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("Resultat.pdf")
                                .build().toString())
                .body(resource);
    }

    @PutMapping
    public ResponseEntity<AnalyseDTO> updateAnalyse(@RequestBody AnalyseDTO analyseDTO){
        AnalyseDTO analyseDTO1=i_analyse.showAnalyseWithId(analyseDTO.getIdAnalyse());
        analyseDTO1.setDateFin(analyseDTO.getDateFin());
        analyseDTO1.setDateDebut(analyseDTO.getDateDebut());
        analyseDTO1.setCommantaire(analyseDTO.getCommantaire());
        analyseDTO1=i_analyse.modAnalyse(analyseDTO1);
        System.out.println(analyseDTO1);
        return new ResponseEntity<>(analyseDTO1, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAnalyse(@PathVariable(value = "id") Long id_analyse){
        AnalyseDTO analyseDTO=i_analyse.showAnalyseWithId(id_analyse);
        //analyseDTO.setDeleted(Boolean.TRUE);
        Map<String,Boolean> response=new HashMap<>();
        if(i_analyse.delAnalyse(analyseDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/planification")
    public ResponseEntity<PlanificationDTO> affectAnalyse(@RequestBody PlanificationDTO planificationDTO){
        planificationDTO=i_analyse.planifierAnalyse(planificationDTO);
        return new ResponseEntity<>(planificationDTO, HttpStatus.OK);
    }
}
