package org.techlab.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techlab.labxpert.entity.Numeration;

@Repository
public interface NumerationRepository extends JpaRepository<Numeration,Long> {
}
