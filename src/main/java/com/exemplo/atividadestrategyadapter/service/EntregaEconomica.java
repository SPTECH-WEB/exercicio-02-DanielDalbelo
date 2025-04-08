package com.exemplo.atividadestrategyadapter.service;

import org.springframework.stereotype.Component;

@Component
public class EntregaEconomica implements FreteStrategy {

    @Override
    public double calcularFrete(double valor) {
        return valor * 0.05;
    }

    public String modalidade() {
        return "Entrega economica";
    }
}
