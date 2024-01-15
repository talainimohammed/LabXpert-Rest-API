package org.techlab.labxpert.service;


import org.techlab.labxpert.entity.Patient;

import java.util.List;

public interface I_Patient {
    public Patient addPatient(Patient patient);
    public Patient modPatient(Patient patient);
    public Boolean delPatient(Patient patient);
    public List<Patient> showPatients();
}
