package org.techlab.labxpert.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techlab.labxpert.entity.Patient;
import org.techlab.labxpert.repository.PatientRepository;
import org.techlab.labxpert.service.I_Patient;

import java.util.List;
@Service
public class PatientServiceImp implements I_Patient{
    @Autowired
    PatientRepository patientRepository;
    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient modPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Boolean delPatient(Patient patient) {
        return null;
    }

    @Override
    public List<Patient> showPatients() {
        return patientRepository.findAll();
    }
}
