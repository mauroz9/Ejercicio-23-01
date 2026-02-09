package com.salesianostriana.dam.viviendafilter.dto;

import com.salesianostriana.dam.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.model.TipoVivienda;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;

public record CreateViviendaDto(

        @NotBlank
        @Size(max = 120)
        String titulo,

        @NotBlank
        @Size(max = 2000)
        String descripcion,

        @NotNull
        @Size(max = 80)
        String ciudad,

        @NotBlank
        @Size(max = 80)
        String provincia,

        @NotNull
        @Positive
        Integer precio,

        @NotNull
        @Positive
        Integer metrosCuadrados,

        @NotNull
        @Min(value = 0)
        Integer habitaciones,

        @NotNull
        @Min(value = 0)
        Integer banos,

        @NotNull
        TipoVivienda tipo,

        @NotNull
        EstadoVivienda estado,

        @NotNull
        Boolean disponible,

        @NotNull
        Boolean ascensor,

        @NotNull
        Boolean terraza,

        @NotNull
        Boolean garaje
){
}
