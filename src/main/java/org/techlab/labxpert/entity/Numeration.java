package org.techlab.labxpert.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    private Norme norme;
    @JsonBackReference
    @ManyToOne
    private Analyse analyse;
    @Column(name="`is_deleted`")
    private Boolean deleted;


}
