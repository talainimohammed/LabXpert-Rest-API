package org.techlab.labxpert.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name="planifications")
public class Planification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlanification;
    @OneToOne
    private Analyse analyse;
    @ManyToOne
    private Utilisateur utilisateur;

    private Date dateDebut;
    private Date dateFin;

    public Planification() {
    }

}
