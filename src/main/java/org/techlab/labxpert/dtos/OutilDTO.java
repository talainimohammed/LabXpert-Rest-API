package org.techlab.labxpert.dtos;
import lombok.Data;
import org.techlab.labxpert.entity.Fournisseur;

@Data
public class OutilDTO {
    private Long idOutil;
    private String libelle;
    private int quantite;
    private Fournisseur fournisseur;
    private Boolean deleted;
}
