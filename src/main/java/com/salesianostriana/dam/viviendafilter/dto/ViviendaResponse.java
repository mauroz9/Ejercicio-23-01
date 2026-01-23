package com.salesianostriana.dam.viviendafilter.dto;


import com.salesianostriana.dam.viviendafilter.model.Vivienda;

import java.time.LocalDate;

public record ViviendaResponse(Long id, String titulo, String ciudad, String provincia, Integer precio, Integer metrosCuadrados, Integer habitaciones, Integer banos, String tipo, String estado, Boolean disponible, LocalDate fechaPublicacion) {

    public static ViviendaResponse of(Vivienda vivienda){
        return new ViviendaResponse(
                vivienda.getId(),
                vivienda.getTitulo(),
                vivienda.getCiudad(),
                vivienda.getProvincia(),
                vivienda.getPrecio(),
                vivienda.getMetrosCuadrados(),
                vivienda.getHabitaciones(),
                vivienda.getBanos(),
                vivienda.getTipo().toString(),
                vivienda.getEstado().toString(),
                vivienda.getDisponible(),
                vivienda.getFechaPublicacion()
        );
    }

}
