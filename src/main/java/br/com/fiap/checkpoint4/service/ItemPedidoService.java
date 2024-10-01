package br.com.fiap.checkpoint4.service;

import br.com.fiap.checkpoint4.dtos.*;
import br.com.fiap.checkpoint4.model.Item_Pedido;
import br.com.fiap.checkpoint4.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoResponseDto createItemPedido(ItemPedidoRequestCreateDto dto) {
    	Item_Pedido itemPedido = new Item_Pedido();
        itemPedido.setPedido(dto.getIdPedido());
        itemPedido.setId(dto.getIdProduto());
        itemPedido.setQuantidade(dto.getQuantidade());

        Item_Pedido savedItemPedido = itemPedidoRepository.save(itemPedido);
        ItemPedidoResponseDto responseDto = new ItemPedidoResponseDto();
        responseDto.setId(savedItemPedido.getId());
        responseDto.setIdPedido(savedItemPedido.getPedido());
        responseDto.setIdProduto(savedItemPedido.getId());
        responseDto.setQuantidade(savedItemPedido.getQuantidade());
        return responseDto;
    }

    public List<ItemPedidoResponseDto> getAllItemPedidos() {
        List<Item_Pedido> itemPedidos = itemPedidoRepository.findAll();
        return itemPedidos.stream().map(itemPedido -> {
            ItemPedidoResponseDto dto = new ItemPedidoResponseDto();
            dto.setId(itemPedido.getId());
            dto.setIdPedido(itemPedido.getPedido());
            dto.setIdProduto(itemPedido.getId());
            dto.setQuantidade(itemPedido.getQuantidade());
            return dto;
        }).collect(Collectors.toList());
    }

    public ItemPedidoResponseDto getItemPedidoById(Long id) {
        Optional<Item_Pedido> optionalItemPedido = itemPedidoRepository.findById(id);
        if (optionalItemPedido.isPresent()) {
        	Item_Pedido itemPedido = optionalItemPedido.get();
            ItemPedidoResponseDto dto = new ItemPedidoResponseDto();
            dto.setId(itemPedido.getId());
            dto.setIdPedido(itemPedido.getPedido());
            dto.setIdProduto(itemPedido.getId());
            dto.setQuantidade(itemPedido.getQuantidade());
            return dto;
        }
        return null;
    }

    public ItemPedidoResponseDto updateItemPedido(Long id, ItemPedidoRequestUpdateDto dto) {
        Optional<Item_Pedido> optionalItemPedido = itemPedidoRepository.findById(id);
        if (optionalItemPedido.isPresent()) {
        	Item_Pedido itemPedido = optionalItemPedido.get();
            itemPedido.setPedido(dto.getIdPedido());
            itemPedido.setId(dto.getIdProduto());
            itemPedido.setQuantidade(dto.getQuantidade());

            Item_Pedido updatedItemPedido = itemPedidoRepository.save(itemPedido);
            ItemPedidoResponseDto responseDto = new ItemPedidoResponseDto();
            responseDto.setId(updatedItemPedido.getId());
            responseDto.setIdPedido(updatedItemPedido.getPedido());
            responseDto.setIdProduto(updatedItemPedido.getId());
            responseDto.setQuantidade(updatedItemPedido.getQuantidade());
            return responseDto;
        }
        return null;
    }

    public void deleteItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}

