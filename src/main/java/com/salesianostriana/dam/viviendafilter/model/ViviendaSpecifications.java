package com.salesianostriana.dam.viviendafilter.model;

import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;

public interface ViviendaSpecifications {

    static PredicateSpecification<Vivienda> ciudadContains(String ciudad){
        return (from, builder) ->
                ciudad == null ? builder.and(): builder.like(builder.lower(from.get("ciudad")), "%" + ciudad.toLowerCase() + "%");
    }

    static PredicateSpecification<Vivienda> provinciaEquals(String provincia){
        return(from, builder) ->
                provincia == null ? builder.and(): builder.equal(builder.lower(from.get("provincia")), provincia.toLowerCase());
    }

    static PredicateSpecification<Vivienda> precioBetween(Integer precioMin, Integer precioMax){
        return (from, builder) ->{
            Integer realMin = (precioMin != null) ? precioMin : 0;
            Integer realMax = (precioMax != null) ? precioMax : Integer.MAX_VALUE;

            return builder.between(from.get("precio"), realMin, realMax);
        };
    }

    static PredicateSpecification<Vivienda> metrosBetween(Integer metrosMin, Integer metrosMax){
        return (from, builder) ->{
            Integer realMin = (metrosMin != null) ? metrosMin : 0;
            Integer realMax = (metrosMax != null) ? metrosMax : Integer.MAX_VALUE;

            return builder.between(from.get("metrosCuadrados"), realMin, realMax);
        };
    }

    static PredicateSpecification<Vivienda> habitacionesMin(Integer habitacionMinima){
        return (from, builder) ->
                habitacionMinima == null ? builder.and(): builder.greaterThanOrEqualTo(from.get("habitaciones"), habitacionMinima);
    }

    static PredicateSpecification<Vivienda> banosMin(Integer banosMinimo){
        return (from, builder) ->
                banosMinimo == null ? builder.and(): builder.greaterThanOrEqualTo(from.get("banos"), banosMinimo);
    }

    static PredicateSpecification<Vivienda> tipoEquals(TipoVivienda tipoVivienda){
        return (from, builder) ->
                tipoVivienda == null ? builder.and(): builder.equal(from.get("tipoVivienda"), tipoVivienda);
    }

    static PredicateSpecification<Vivienda> estadoEquals(EstadoVivienda estadoVivienda){
        return (from, builder) ->
                estadoVivienda == null ? builder.and(): builder.equal(from.get("estadoVivienda"), estadoVivienda);
    }

    static PredicateSpecification<Vivienda> ascensorEquals(Boolean ascensor){
        return (from, builder) ->
                ascensor == null ? builder.and(): builder.equal(from.get("ascensor"), ascensor);
    }

    static PredicateSpecification<Vivienda> terrazaEquals(Boolean terraza){
        return (from, builder) ->
                terraza == null ? builder.and(): builder.equal(from.get("terraza"), terraza);
    }

    static PredicateSpecification<Vivienda> garajeEquals(Boolean garaje){
        return (from, builder) ->
                garaje == null ? builder.and(): builder.equal(from.get("garaje"), garaje);
    }

    static PredicateSpecification<Vivienda> soloDisponibles(Boolean disponible){
        return (from, builder) ->
                disponible == null || !disponible ? builder.and(): builder.equal(from.get("disponible"), disponible);
    }
}
