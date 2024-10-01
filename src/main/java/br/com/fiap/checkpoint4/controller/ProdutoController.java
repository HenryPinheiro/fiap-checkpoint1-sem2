package br.com.fiap.checkpoint4.controller;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> createProduto(@RequestBody ProdutoRequestCreateDto dto) {
        ProdutoResponseDto createdProduto = produtoService.createProduto(dto);
        return ResponseEntity.ok(createdProduto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> getAllProdutos() {
        List<ProdutoResponseDto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getProdutoById(@PathVariable Long id) {
        ProdutoResponseDto produto = produtoService.getProdutoById(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> updateProduto(@PathVariable Long id, @RequestBody ProdutoRequestUpdateDto dto) {
        ProdutoResponseDto updatedProduto = produtoService.updateProduto(id, dto);
        if (updatedProduto != null) {
            return ResponseEntity.ok(updatedProduto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
