package com.salesianostriana.dam.viviendafilter.controller;

import com.salesianostriana.dam.viviendafilter.dto.ViviendaResponse;
import com.salesianostriana.dam.viviendafilter.model.EstadoVivienda;
import com.salesianostriana.dam.viviendafilter.model.TipoVivienda;
import com.salesianostriana.dam.viviendafilter.service.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping("/viviendas")
    public ResponseEntity<Page<ViviendaResponse>> getAll(Pageable pageable,
                                                         @RequestParam(required = false) String ciudad,
                                                         @RequestParam(required = false) String provincia,
                                                         @RequestParam(required = false) Integer precioMin,
                                                         @RequestParam(required = false) Integer precioMax,
                                                         @RequestParam(required = false) Integer metrosMin,
                                                         @RequestParam(required = false) Integer metrosMax,
                                                         @RequestParam(required = false) Integer habitacionesMin,
                                                         @RequestParam(required = false) Integer banosMin,
                                                         @RequestParam(required = false)TipoVivienda tipoVivienda,
                                                         @RequestParam(required = false) EstadoVivienda estadoVivienda,
                                                         @RequestParam(required = false) Boolean ascensor,
                                                         @RequestParam(required = false) Boolean terraza,
                                                         @RequestParam(required = false) Boolean garaje,
                                                         @RequestParam(required = false) Boolean disponible
                                                         ){
        return ResponseEntity.ok(viviendaService.getAll(pageable).map(ViviendaResponse::of));

    }
}
