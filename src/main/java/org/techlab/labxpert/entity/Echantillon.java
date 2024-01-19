package org.techlab.labxpert.entity;

import lombok.Data;
import lombok.ToString;
import org.techlab.labxpert.Enum.StatutEchantillon;

import javax.persistence.*;
import java.util.Collection;
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
    @ToString.Exclude
    @OneToMany(mappedBy = "echantillon", cascade = CascadeType.ALL)
    private Collection<Analyse> analyses;
    @Column(name="is_deleted")
    private Boolean deleted;

    public Echantillon() {
    }
}
