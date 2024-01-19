package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutEchantillon;
import org.techlab.labxpert.entity.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class EchantillonDTO {
    private Long idEchantillon;
    private Patient patient;
    private Utilisateur utilisateur;
    private Date datePrelevement;
    private String typeAnalyse;
    private StatutEchantillon Status;
    private Collection<Analyse> analyses;
    private Collection<OutilEchantillon> outilEchantillonList;
    private Boolean deleted=false;
}
