package com.example.demo.model;

public class MensajeLongPolling {
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    private String texto;
    private long timestamp;

    public MensajeLongPolling(String usuario, String texto) {
        this.usuario = usuario;
        this.texto = texto;
        this.timestamp = System.currentTimeMillis();}

    public MensajeLongPolling() {}
}