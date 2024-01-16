package org.techlab.labxpert.dtos;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutEchantillon;
import org.techlab.labxpert.entity.Patient;
import org.techlab.labxpert.entity.Echantillon;
@Data

public class EchantillonDTO {
    private Long idEchantillon;
    private Patient patient;
    private String typeAnalyse;
    private StatutEchantillon Status;
    private Boolean deleted=false;
}
