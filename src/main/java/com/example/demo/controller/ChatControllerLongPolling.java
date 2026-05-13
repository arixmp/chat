package com.example.demo.controller;

import com.example.demo.model.MensajeLongPolling;
import com.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatControllerLongPolling {

        @Autowired
        private ChatService chatService;

        @GetMapping("/mensajes")
        public DeferredResult<ResponseEntity<List<MensajeLongPolling>>> recibirMensajes() {
            DeferredResult<ResponseEntity<List<MensajeLongPolling>>> output = new DeferredResult<>(20000L,
                    ResponseEntity.ok(List.of()));  // ← responde vacío si vence el timeout
            chatService.agregar(output);
            return output;
        }

        @PostMapping("/mensajes")
        public ResponseEntity<String> enviarMensaje(@RequestBody MensajeLongPolling msg) {
            chatService.enviar(msg);
            return ResponseEntity.ok("ok");
        }


    }
