package com.exemplo.atividadestrategyadapter.service;

import org.springframework.stereotype.Service;


public class APIExternaTransportadora {

    public double calculoExterno(double peso) {
        return peso * 7.5 + 15;
    }
}

