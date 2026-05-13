package com.example.demo.controller;

import com.example.demo.model.Mensaje;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // Recibe mensajes de chat y los transmite a todos
    @MessageMapping("/chat.enviar")
    @SendTo("/topic/publico")
    public Mensaje enviarMensaje(@Payload Mensaje mensaje) {
        return mensaje;
    }

    // Registra cuando un usuario se une
    @MessageMapping("/chat.unirse")
    @SendTo("/topic/publico")
    public Mensaje unirseChat(@Payload Mensaje mensaje,
                              SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", mensaje.getUsuario());
        return mensaje;
    }
}