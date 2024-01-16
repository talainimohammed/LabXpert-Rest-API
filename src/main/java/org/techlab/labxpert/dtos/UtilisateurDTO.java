package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.Enum.RoleUser;

import java.util.Date;
@Data
public class UtilisateurDTO {
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String adresse;
    private String tel;
    private RoleUser role;
    private String password;
    private String nomUtilisateur;
    private Boolean deleted=false;

}