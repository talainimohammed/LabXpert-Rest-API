package org.techlab.labxpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="analyses")
public class Analyse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnalyse;
    @ManyToOne
    private Echantillon echantillon;
    private String nomAnalyse;
    private Date dateDebut;
    private Date dateFin;
    private String commantaire;

    public Analyse() {
    }
}
