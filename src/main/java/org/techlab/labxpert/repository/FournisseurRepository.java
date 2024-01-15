package org.techlab.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techlab.labxpert.entity.Fournisseur;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
