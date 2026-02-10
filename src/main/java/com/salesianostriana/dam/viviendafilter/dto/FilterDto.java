package com.salesianostriana.dam.viviendafilter.dto;

import com.salesianostriana.dam.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.model.TipoVivienda;

public record FilterDto(String ciudad, String provincia, Integer precioMin, Integer precioMax, Integer metrosMin, Integer metrosMax, Integer habitacionesMin, Integer banosMin, TipoVivienda tipoVivienda, EstadoVivienda estadoVivienda, Boolean ascensor, Boolean terraza, Boolean garaje, Boolean disponible) {

    public static FilterDto of(String ciudad, String provincia, Integer precioMin, Integer precioMax, Integer metrosMin, Integer metrosMax, Integer habitacionesMin, Integer banosMin, TipoVivienda tipoVivienda, EstadoVivienda estadoVivienda, Boolean ascensor, Boolean terraza, Boolean garaje, Boolean disponible){
        return new FilterDto(
                ciudad,
                provincia,
                precioMin,
                precioMax,
                metrosMin,
                metrosMax,
                habitacionesMin,
                banosMin,
                tipoVivienda,
                estadoVivienda,
                ascensor,
                terraza,
                garaje,
                disponible

        );
    }

}
