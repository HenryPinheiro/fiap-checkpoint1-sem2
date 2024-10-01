package br.com.fiap.checkpoint4.service;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.model.Pedido;
import br.com.fiap.checkpoint4.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoResponseDto createPedido(PedidoRequestCreateDto dto) {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setFormaPagamento(dto.getFormaPagamento());
        pedido.setCliente(dto.getIdCliente());

        Pedido savedPedido = pedidoRepository.save(pedido);
        PedidoResponseDto responseDto = new PedidoResponseDto();
        responseDto.setId(savedPedido.getId());
        responseDto.setDataPedido(savedPedido.getDataPedido());
        responseDto.setFormaPagamento(savedPedido.getFormaPagamento());
        responseDto.setIdCliente(savedPedido.getCliente());
        return responseDto;
    }

    public List<PedidoResponseDto> getAllPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(pedido -> {
            PedidoResponseDto dto = new PedidoResponseDto();
            dto.setId(pedido.getId());
            dto.setDataPedido(pedido.getDataPedido());
            dto.setFormaPagamento(pedido.getFormaPagamento());
            dto.setIdCliente(pedido.getCliente());
            return dto;
        }).collect(Collectors.toList());
    }

    public PedidoResponseDto getPedidoById(Long id) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            PedidoResponseDto dto = new PedidoResponseDto();
            dto.setId(pedido.getId());
            dto.setDataPedido(pedido.getDataPedido());
            dto.setFormaPagamento(pedido.getFormaPagamento());
            dto.setIdCliente(pedido.getCliente());
            return dto;
        }
        return null;
    }

    public PedidoResponseDto updatePedido(Long id, PedidoRequestUpdateDto dto) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
        if (optionalPedido.isPresent()) {
            Pedido pedido = optionalPedido.get();
            pedido.setDataPedido(dto.getDataPedido());
            pedido.setFormaPagamento(dto.getFormaPagamento());
            pedido.setCliente(dto.getIdCliente());
            pedido.setStatus(dto.getStatus());

            Pedido updatedPedido = pedidoRepository.save(pedido);
            PedidoResponseDto responseDto = new PedidoResponseDto();
            responseDto.setId(updatedPedido.getId());
            responseDto.setDataPedido(updatedPedido.getDataPedido());
            responseDto.setFormaPagamento(updatedPedido.getFormaPagamento());
            responseDto.setIdCliente(updatedPedido.getCliente());
            responseDto.setStatus(updatedPedido.getStatus());
            return responseDto;
        }
        return null;
    }

    public void deletePedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
