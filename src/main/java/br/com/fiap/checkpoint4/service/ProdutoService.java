package br.com.fiap.checkpoint4.service;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.model.Produto;
import br.com.fiap.checkpoint4.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoResponseDto createProduto(ProdutoRequestCreateDto dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setValor(dto.getValor());

        Produto savedProduto = produtoRepository.save(produto);
        ProdutoResponseDto responseDto = new ProdutoResponseDto();
        responseDto.setId(savedProduto.getId());
        responseDto.setNome(savedProduto.getNome());
        responseDto.setValor(savedProduto.getValor());
        return responseDto;
    }

    public List<ProdutoResponseDto> getAllProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream().map(produto -> {
            ProdutoResponseDto dto = new ProdutoResponseDto();
            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setValor(produto.getValor());
            return dto;
        }).collect(Collectors.toList());
    }

    public ProdutoResponseDto getProdutoById(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            ProdutoResponseDto dto = new ProdutoResponseDto();
            dto.setId(produto.getId());
            dto.setNome(produto.getNome());
            dto.setValor(produto.getValor());
            return dto;
        }
        return null;
    }

    public ProdutoResponseDto updateProduto(Long id, ProdutoRequestUpdateDto dto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            produto.setNome(dto.getNome());
            produto.setValor(dto.getValor());

            Produto updatedProduto = produtoRepository.save(produto);
            ProdutoResponseDto responseDto = new ProdutoResponseDto();
            responseDto.setId(updatedProduto.getId());
            responseDto.setNome(updatedProduto.getNome());
            responseDto.setValor(updatedProduto.getValor());
            return responseDto;
        }
        return null;
    }

    public void deleteProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
