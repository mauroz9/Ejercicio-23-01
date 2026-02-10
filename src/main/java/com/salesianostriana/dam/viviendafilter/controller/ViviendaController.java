package com.salesianostriana.dam.viviendafilter.controller;

import com.salesianostriana.dam.viviendafilter.dto.CreateViviendaDto;
import com.salesianostriana.dam.viviendafilter.dto.FilterDto;
import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.model.TipoVivienda;
import com.salesianostriana.dam.viviendafilter.model.Vivienda;
import com.salesianostriana.dam.viviendafilter.service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping("/viviendas")
    public ResponseEntity<Page<ViviendaResponse>> getAll(@PageableDefault(page = 0, size = 10, sort = "fechaPublicacion",direction = Sort.Direction.DESC) Pageable pageable,
                                                         @RequestParam(required = false) String ciudad,
                                                         @RequestParam(required = false) String provincia,
                                                         @RequestParam(required = false) Integer precioMin,
                                                         @RequestParam(required = false) Integer precioMax,
                                                         @RequestParam(required = false) Integer metrosMin,
                                                         @RequestParam(required = false) Integer metrosMax,
                                                         @RequestParam(required = false) Integer habitacionesMin,
                                                         @RequestParam(required = false) Integer banosMin,
                                                         @RequestParam(required = false) TipoVivienda tipoVivienda,
                                                         @RequestParam(required = false) EstadoVivienda estadoVivienda,
                                                         @RequestParam(required = false) Boolean ascensor,
                                                         @RequestParam(required = false) Boolean terraza,
                                                         @RequestParam(required = false) Boolean garaje,
                                                         @RequestParam(required = false) Boolean disponible
                                                         ){
        FilterDto dto = FilterDto.of(ciudad,
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
                disponible);

        return ResponseEntity.ok(viviendaService.getAll(pageable, dto).map(ViviendaResponse::of));

    }

    @PostMapping("/viviendas")
    public ResponseEntity<ViviendaResponse> createVivienda(@Valid @RequestBody CreateViviendaDto createViviendaDto){

        Vivienda vivienda = Vivienda.builder()
                .titulo(createViviendaDto.titulo())
                .descripcion(createViviendaDto.descripcion())
                .ciudad(createViviendaDto.ciudad())
                .provincia(createViviendaDto.provincia())
                .precio(createViviendaDto.precio())
                .metrosCuadrados(createViviendaDto.metrosCuadrados())
                .habitaciones(createViviendaDto.habitaciones())
                .banos(createViviendaDto.banos())
                .tipo(createViviendaDto.tipo())
                .estado(createViviendaDto.estado())
                .ascensor(createViviendaDto.ascensor())
                .terraza(createViviendaDto.terraza())
                .garaje(createViviendaDto.garaje())
                .disponible(createViviendaDto.disponible())
                .build();


        return ResponseEntity.status(HttpStatus.CREATED).body(ViviendaResponse.of(viviendaService.save(vivienda)));
    }
}
