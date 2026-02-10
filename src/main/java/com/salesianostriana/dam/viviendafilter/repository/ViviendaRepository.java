package com.salesianostriana.dam.viviendafilter.repository;

import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ViviendaRepository extends JpaRepository<Vivienda, Long>, JpaSpecificationExecutor<Vivienda> {

    //Page<Vivienda> findAll(PredicateSpecification<Vivienda> spec, Pageable pageable);

}
