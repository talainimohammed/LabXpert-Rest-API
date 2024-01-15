package org.techlab.labxpert.entity;

import lombok.Data;
import org.techlab.labxpert.Enum.StatutNumeration;

import javax.persistence.*;
@Data
@Entity
@Table(name="numerations")
public class Numeration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNumeration;
    private double value;
    private StatutNumeration statut;
    @OneToOne
    private Norme norme;
    @ManyToOne
    private Analyse analyse;


}
