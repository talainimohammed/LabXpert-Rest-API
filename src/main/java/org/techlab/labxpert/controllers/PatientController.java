package org.techlab.labxpert.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techlab.labxpert.dtos.PatientDTO;
import org.techlab.labxpert.dtos.UtilisateurDTO;
import org.techlab.labxpert.entity.Patient;
import org.techlab.labxpert.service.I_Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/patient")

public class PatientController {
    @Autowired
    I_Patient i_patient;

    @GetMapping
    public List allPatients(){
        List<PatientDTO> listPatient=i_patient.showPatient();
        return listPatient;
    }
    @GetMapping("/{id}")
    public PatientDTO showPatient(@PathVariable(value = "id") Long id_Patient){
        PatientDTO patient=i_patient.showPatientwithid(id_Patient);
        return patient;
    }
    @PostMapping
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO patientDTO1=i_patient.addPatient(patientDTO);
        return new ResponseEntity<>(patientDTO1, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PatientDTO> modPatient(@RequestBody PatientDTO patientDTO){
        PatientDTO patientDTO1=i_patient.modPatient(patientDTO);
        return new ResponseEntity<>(patientDTO1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public Map<String,Boolean> delPatient(@PathVariable(value = "id") Long id_patient ){
        PatientDTO patientDTO=i_patient.showPatientwithid(id_patient);
        patientDTO.setDeleted(true);
        Map<String,Boolean> response=new HashMap<>();
        if(i_patient.delPatient(patientDTO)){
            response.put("deleted",Boolean.TRUE);
        }
        return response;
    }







}
