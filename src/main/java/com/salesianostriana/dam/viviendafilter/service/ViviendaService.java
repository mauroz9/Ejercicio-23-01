package com.salesianostriana.dam.viviendafilter.service;

import com.salesianostriana.dam.viviendafilter.dto.FilterDto;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.model.ViviendaSpecifications;
import com.salesianostriana.dam.viviendafilter.repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<Vivienda> getAll(Pageable pageable, FilterDto dto){

        PredicateSpecification<Vivienda> spec = PredicateSpecification.allOf(
            ViviendaSpecifications.ciudadContains(dto.ciudad()),
                ViviendaSpecifications.provinciaEquals(dto.provincia()),
                    ViviendaSpecifications.precioBetween(dto.precioMin(), dto.precioMax()),
                        ViviendaSpecifications.metrosBetween(dto.metrosMin(), dto.metrosMax()),
                            ViviendaSpecifications.habitacionesMin(dto.habitacionesMin()),
                                ViviendaSpecifications.banosMin(dto.banosMin()),
                                    ViviendaSpecifications.tipoEquals(dto.tipoVivienda()),
                                        ViviendaSpecifications.estadoEquals(dto.estadoVivienda()),
                                            ViviendaSpecifications.ascensorEquals(dto.ascensor()),
                                                ViviendaSpecifications.terrazaEquals(dto.terraza()),
                                                    ViviendaSpecifications.garajeEquals(dto.garaje()),
                                                        ViviendaSpecifications.soloDisponibles(dto.disponible())

        );

        return viviendaRepository.findBy(spec, q -> q.page(pageable));
    }

    public Vivienda save(Vivienda vivienda){
        vivienda.setFechaPublicacion(LocalDate.now());

        return viviendaRepository.save(vivienda);
    }
}
