package org.techlab.labxpert.entity;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutEchantillon;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="echantillons")
public class Echantillon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEchantillon;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Utilisateur utilisateur;
    private Date datePrelevement;
    private String typeAnalyse;
    private StatutEchantillon Status;
    @Column(name="is_deleted")
    private Boolean deleted;

    public Echantillon() {
    }
}
