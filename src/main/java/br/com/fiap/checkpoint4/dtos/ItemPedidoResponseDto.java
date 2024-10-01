package br.com.fiap.checkpoint4.dtos;

import br.com.fiap.checkpoint4.model.Pedido;

public class ItemPedidoResponseDto {
    private Long id;
    private Pedido idPedido;
    private Long idProduto;
    private Integer quantidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido pedido) {
        this.idPedido = pedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

