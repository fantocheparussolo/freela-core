package br.com.freela.model;

import br.com.freela.model.Cliente;
import br.com.freela.exception.PedidoInvalidoException;

public class PedidoTrabalho {

    private int idPedido;
    private Cliente cliente;
    private Trabalhador trabalhador;
    private TipoTrabalho tipoTrabalho;
    private String local;
    private String status;
    private double valorProposto;

    public PedidoTrabalho(int idPedido, Cliente cliente, Trabalhador trabalhador, TipoTrabalho tipoTrabalho, String local, double valorProposto) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.trabalhador = trabalhador;
        this.tipoTrabalho = tipoTrabalho;
        this.local = local;
        this.status = "Pendente";
        this.valorProposto = valorProposto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public TipoTrabalho getTipoTrabalho() {
        return tipoTrabalho;
    }

    public String getLocal() {
        return local;
    }

    public String getStatus() {
        return status;
    }

    public double getValorProposto() {
        return valorProposto;
    }

    public void confirmarPedido() {
        this.status = "Confirmado";
    }

    public void cancelarPedido() {
    if (!status.equals("Confirmado")) {
        this.status = "Cancelado";
    } else {
        throw new PedidoInvalidoException(
            "Não é possível cancelar um pedido já confirmado."
        );
    }
}

}
