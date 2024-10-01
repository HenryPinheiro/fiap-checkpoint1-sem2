package br.com.fiap.checkpoint4.controller;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDto> createCliente(@RequestBody ClienteRequestCreateDto dto) {
        ClienteResponseDto createdCliente = clienteService.createCliente(dto);
        return ResponseEntity.ok(createdCliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> getAllClientes() {
        List<ClienteResponseDto> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> getClienteById(@PathVariable Long id) {
        ClienteResponseDto cliente = clienteService.getClienteById(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> updateCliente(@PathVariable Long id, @RequestBody ClienteRequestUpdateDto dto) {
        ClienteResponseDto updatedCliente = clienteService.updateCliente(id, dto);
        if (updatedCliente != null) {
            return ResponseEntity.ok(updatedCliente);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}
