package br.com.fiap.checkpoint4.controller;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ResponseEntity<ItemPedidoResponseDto> createItemPedido(@RequestBody ItemPedidoRequestCreateDto dto) {
        ItemPedidoResponseDto createdItemPedido = itemPedidoService.createItemPedido(dto);
        return ResponseEntity.ok(createdItemPedido);
    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoResponseDto>> getAllItemPedidos() {
        List<ItemPedidoResponseDto> itemPedidos = itemPedidoService.getAllItemPedidos();
        return ResponseEntity.ok(itemPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> getItemPedidoById(@PathVariable Long id) {
        ItemPedidoResponseDto itemPedido = itemPedidoService.getItemPedidoById(id);
        if (itemPedido != null) {
            return ResponseEntity.ok(itemPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedidoResponseDto> updateItemPedido(@PathVariable Long id, @RequestBody ItemPedidoRequestUpdateDto dto) {
        ItemPedidoResponseDto updatedItemPedido = itemPedidoService.updateItemPedido(id, dto);
        if (updatedItemPedido != null) {
            return ResponseEntity.ok(updatedItemPedido);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItemPedido(@PathVariable Long id) {
        itemPedidoService.deleteItemPedido(id);
        return ResponseEntity.noContent().build();
    }
}
