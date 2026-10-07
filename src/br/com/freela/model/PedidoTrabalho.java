package br.com.freela.model;

import br.com.freela.model.Cliente;

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
            System.out.println("Não é possível cancelar um pedidio já confirmado.");
        }
    }

    public void exibirPedido() {
        System.out.println("Pedido: " + idPedido);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Trabalhador: " + trabalhador.getNome());
        System.out.println("Tipo de trabalho(s): " + tipoTrabalho.getNomeTrabalho());
        System.out.println("Local: " + local);
        System.out.println("Valor proposto: R$ " + valorProposto);
        System.out.println("Status: " + status);

    }

}
