package org.techlab.labxpert.dtos;

import lombok.Data;

import java.util.Date;

@Data

public class PatientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private String tel;
    private Boolean deleted=false;
}
