package br.com.fiap.checkpoint4.dtos;

import br.com.fiap.checkpoint4.model.Pedido;

public class ItemPedidoRequestCreateDto {
    private Pedido idPedido;
    private Long idProduto;
    private Integer quantidade;

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
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
