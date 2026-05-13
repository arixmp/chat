// ChatService.java
package com.example.demo.service;

import com.example.demo.model.MensajeLongPolling;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ChatService {

    private final List<DeferredResult<ResponseEntity<List<MensajeLongPolling>>>> clientes =
            new CopyOnWriteArrayList<>();

    public void agregar(DeferredResult<ResponseEntity<List<MensajeLongPolling>>> result) {
        clientes.add(result);
        result.onCompletion(() -> clientes.remove(result));
    }

    public void enviar(MensajeLongPolling msg) {
        for (DeferredResult<ResponseEntity<List<MensajeLongPolling>>> cliente : clientes) {
            cliente.setResult(ResponseEntity.ok(List.of(msg)));
        }
        clientes.clear();
    }
}