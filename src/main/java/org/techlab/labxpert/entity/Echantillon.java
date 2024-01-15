package org.techlab.labxpert.entity;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutEchantillon;

import javax.persistence.*;
@Data
@Entity
@Table(name="echantillons")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEchantillon;
    @ManyToOne
    private Patient patient;
    private String typeAnalyse;
    private StatutEchantillon Status;

    public Echantillon() {
    }
}
