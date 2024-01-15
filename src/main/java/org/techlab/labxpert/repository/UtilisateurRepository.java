package org.techlab.labxpert.repository;

import org.techlab.labxpert.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
}
