package org.techlab.labxpert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techlab.labxpert.entity.Reactif;

@Repository
public interface ReactifRepository extends JpaRepository<Reactif,Long> {
}
