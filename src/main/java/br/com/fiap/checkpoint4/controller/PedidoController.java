package br.com.fiap.checkpoint4.controller;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDto> createPedido(@RequestBody PedidoRequestCreateDto dto) {
        PedidoResponseDto createdPedido = pedidoService.createPedido(dto);
        return ResponseEntity.ok(createdPedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> getAllPedidos() {
        List<PedidoResponseDto> pedidos = pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> getPedidoById(@PathVariable Long id) {
        PedidoResponseDto pedido = pedidoService.getPedidoById(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> updatePedido(@PathVariable Long id, @RequestBody PedidoRequestUpdateDto dto) {
        PedidoResponseDto updatedPedido = pedidoService.updatePedido(id, dto);
        if (updatedPedido != null) {
            return ResponseEntity.ok(updatedPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
