package org.techlab.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techlab.labxpert.entity.Norme;

@Repository
public interface NormeRepository extends JpaRepository<Norme,Long> {
}
