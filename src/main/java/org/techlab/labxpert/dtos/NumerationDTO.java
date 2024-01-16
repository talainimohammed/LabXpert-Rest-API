package org.techlab.labxpert.dtos;

import org.techlab.labxpert.Enum.StatutNumeration;
import org.techlab.labxpert.entity.Analyse;
import org.techlab.labxpert.entity.Norme;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class NumerationDTO {
    private Long idNumeration;
    private double value;
    private StatutNumeration statut;
    private Norme norme;
    private Analyse analyse;
    private Boolean deleted=false;
}
