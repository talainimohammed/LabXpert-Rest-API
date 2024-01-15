package org.techlab.labxpert.dtos;

import org.techlab.labxpert.entity.Echantillon;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class AnalyseDTO {
    private Long idAnalyse;
    private Echantillon echantillon;
    private String nomAnalyse;
    private Date dateDebut;
    private Date dateFin;
    private String commantaire;
    private Boolean deleted;
}
