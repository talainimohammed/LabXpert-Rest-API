package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutEchantillon;
import org.techlab.labxpert.entity.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class EchantillonDTO {
    private Long idEchantillon;
    private Patient patient;
    @NotNull(message="nom null")

    private Utilisateur utilisateur;
    @NotNull(message="nom null")
    private Date datePrelevement;
    @NotBlank(message="nom null")
    private String typeAnalyse;

    @NotBlank(message="nom null")
    private StatutEchantillon Status;
    private Collection<Analyse> analyses;
    private Collection<OutilEchantillon> outilEchantillonList;
    private boolean deleted;
}
