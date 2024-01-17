package org.techlab.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techlab.labxpert.entity.Analyse;

import java.util.List;

@Repository
public interface AnalyseRepository extends JpaRepository<Analyse,Long> {
    List<Analyse> findByDeletedFalse();
}
