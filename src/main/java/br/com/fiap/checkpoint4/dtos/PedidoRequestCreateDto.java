package br.com.fiap.checkpoint4.dtos;

import java.util.Date;

import br.com.fiap.checkpoint4.model.Cliente;

public class PedidoRequestCreateDto {
    private Date dataPedido;
    private String formaPagamento;
    private Cliente idCliente;

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
}
