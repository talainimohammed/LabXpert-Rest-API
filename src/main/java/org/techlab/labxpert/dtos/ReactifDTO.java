package org.techlab.labxpert.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.entity.Fournisseur;
import org.techlab.labxpert.entity.Reactif;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@NoArgsConstructor
public class ReactifDTO {

    private Long idReactif;
    private String nom;
    private String description;
    private int quantite;
    private Date dateExpiration;
    private Fournisseur fournisseur;

    private Boolean deleted=false;

    public ReactifDTO(String nom, String description, int quantite, Date dateExpiration, Fournisseur fournisseur) {
        this.nom = nom;
        this.description = description;
        this.quantite = quantite;
        this.dateExpiration = dateExpiration;
        this.fournisseur = fournisseur;
    }
}
