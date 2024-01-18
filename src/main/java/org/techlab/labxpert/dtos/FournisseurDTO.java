package org.techlab.labxpert.dtos;

import lombok.Data;

@Data
public class FournisseurDTO {
    private Long idFournisseur;
    private String nom;
    private String adresse;
    private String tel;
    private Boolean deleted=false;
}
