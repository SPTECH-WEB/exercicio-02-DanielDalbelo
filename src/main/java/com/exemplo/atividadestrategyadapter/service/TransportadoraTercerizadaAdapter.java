package com.exemplo.atividadestrategyadapter.service;

public class TransportadoraTercerizadaAdapter implements FreteStrategy{

    private final APIExternaTransportadora apiExterna = new APIExternaTransportadora();

    @Override
    public double calcularFrete(double peso) {
        return apiExterna.calculoExterno(peso); // integração via adapter
    }

    @Override
    public String modalidade() {
        return "terceirizada";
    }
}
