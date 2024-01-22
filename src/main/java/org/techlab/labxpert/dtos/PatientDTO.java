package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.entity.Echantillon;

import java.util.Date;
import java.util.List;

@Data

public class PatientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private String tel;
    private List<Echantillon> echantillons;
    private Boolean deleted=false;
}
