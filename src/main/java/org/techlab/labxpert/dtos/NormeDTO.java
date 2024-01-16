package org.techlab.labxpert.dtos;

import lombok.Data;

@Data
public class NormeDTO {
    private Long idNorme;
    private String libelle;
    private  String unite;
    private double maxValue;
    private double minValue;
    private Boolean deleted=false;
}
