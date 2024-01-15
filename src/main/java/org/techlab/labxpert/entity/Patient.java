package org.techlab.labxpert.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name="patients")
public class Patient extends Personne{

    /*@OneToMany(mappedBy = "patient")
    private List<Echantillon> echantillons;*/

    public Patient() {

    }
}
