package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.entity.Fournisseur;
import org.techlab.labxpert.entity.Reactif;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
public class ReactifDTO {

    private Long idReactif;
    private String nom;
    private String description;
    private int quantite;
    private Date dateExpiration;
    private Fournisseur fournisseur;

    private Boolean deleted;
}
