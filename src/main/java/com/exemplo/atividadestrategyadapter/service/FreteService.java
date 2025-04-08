package com.exemplo.atividadestrategyadapter.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Service("frete")
public class FreteService {

    private final List<FreteStrategy> estrategias = new ArrayList<>();
    private final List<Notificador> notificadores = new ArrayList<>();

    public FreteService() {
        estrategias.add(new EntregaExpressa());
        estrategias.add(new EntregaEconomica());
        estrategias.add(new TransportadoraTercerizadaAdapter());
        notificadores.add(new EmailNotificador());
    }

    public double calcularFrete(double peso, String modalidade) {
        FreteStrategy estrategia = estrategias.stream()
                .filter(e -> e.modalidade().equalsIgnoreCase(modalidade))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Modalidade inválida"));

        double valor = estrategia.calcularFrete(peso);

        notificadores.forEach(n -> n.notificar("Frete calculado: R$" + valor + " para modalidade " + modalidade));

        return valor;
    }
}
