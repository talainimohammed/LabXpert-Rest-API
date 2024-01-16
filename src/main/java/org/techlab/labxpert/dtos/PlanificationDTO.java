package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.entity.Utilisateur;
import java.util.Date;

@Data
public class PlanificationDTO {
    private Long idPlanification;
    private Analyse analyse;
    private Utilisateur utilisateur;
    private Date dateDebut;
    private Date dateFin;
    private Boolean deleted;
}
