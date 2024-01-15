package org.techlab.labxpert.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="fournisseurs")
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    private String nom;
    private String adresse;
    private String tel;

    public Fournisseur() {
    }
}
