package com.exemplo.atividadestrategyadapter.controller;

import com.exemplo.atividadestrategyadapter.service.FreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @GetMapping
    public ResponseEntity<Double> calcular(@RequestParam Double peso, @RequestParam String modalidade) {
        double valor = freteService.calcularFrete(peso, modalidade);
        return ResponseEntity.ok(valor);
    }

}
