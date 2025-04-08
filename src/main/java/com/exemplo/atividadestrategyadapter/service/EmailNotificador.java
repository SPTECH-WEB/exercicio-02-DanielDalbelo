package com.exemplo.atividadestrategyadapter.service;

public class EmailNotificador implements Notificador {
    public void notificar(String mensagem) {
        System.out.println(mensagem);
    }
}
