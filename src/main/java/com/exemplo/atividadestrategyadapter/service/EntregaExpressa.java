package com.exemplo.atividadestrategyadapter.service;

import org.springframework.stereotype.Component;

@Component
public class EntregaExpressa implements FreteStrategy {
    @Override
    public double calcularFrete(double valor) {
        return valor * 0.20;
    }

    @Override
    public String modalidade() {
        return "Entrega expressa";
    }


}
