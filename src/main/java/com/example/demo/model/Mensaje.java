package com.example.demo.model;

import lombok.Data;

@Data
public class Mensaje {
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String usuario;
    private String contenido;
    private String tipo; // "CHAT", "JOIN", "LEAVE"
}