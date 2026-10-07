package br.com.freela.main;

import br.com.freela.dao.ClienteRepositorio;
import br.com.freela.dao.TrabalhadorRepositorio;
import br.com.freela.exception.DadosInvalidosException;
import br.com.freela.model.TipoCadastro;
import br.com.freela.service.CadastroService;
import br.com.freela.service.DadosCadastro;
import br.com.freela.service.ValidadorCadastro;
import br.com.freela.exception.PedidoInvalidoException;
import br.com.freela.model.Cliente;
import br.com.freela.model.PedidoTrabalho;
import br.com.freela.model.Perfil;
import br.com.freela.model.TipoTrabalho;
import br.com.freela.model.Trabalhador;

public class FreelaApp {

    private static int falhas = 0;

    // DAOs falsos: só contam as chamadas
    private static class ClienteFalso implements ClienteRepositorio {

        int chamadas = 0;

        @Override
        public void cadastrarCliente(String nome, String cpf, String rg, String cidade,
                String email, String senha, String telefone) {
            chamadas++;
        }
    }

    private static class TrabalhadorFalso implements TrabalhadorRepositorio {

        int chamadas = 0;
        String ultimoTipoTrabalho;

        @Override
        public void cadastrarTrabalhador(String nome, String cpf, String rg, String cidade,
                String email, String senha, String telefone, String tipoTrabalho) {
            chamadas++;
            ultimoTipoTrabalho = tipoTrabalho;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testes do FreelaCore ===");

        ValidadorCadastro validador = new ValidadorCadastro();

        // Validação da conta
        verificar("Conta válida não lança erro",
                !lancaErro(() -> validador.validarConta("a@b.com", "123")));
        verificar("Conta sem senha lança erro",
                lancaErro(() -> validador.validarConta("a@b.com", "")));
        verificar("Conta sem e-mail lança erro",
                lancaErro(() -> validador.validarConta(null, "123")));

        // Validação dos dados
        verificar("Cliente completo é válido",
                !lancaErro(() -> validador.validarDados(cliente())));
        verificar("Trabalhador sem tipo de trabalho lança erro",
                lancaErro(() -> validador.validarDados(trabalhador(""))));
        verificar("Nome só com espaços lança erro",
                lancaErro(() -> validador.validarDados(new DadosCadastro(
                "   ", "111", "222", "Curitiba", "a@b.com", "123", "9999",
                TipoCadastro.CLIENTE, ""))));

        // Cadastro de cliente
        ClienteFalso clientes = new ClienteFalso();
        TrabalhadorFalso trabalhadores = new TrabalhadorFalso();
        CadastroService service = new CadastroService(validador, clientes, trabalhadores);

        service.cadastrar(cliente());
        verificar("Cadastro de cliente chama só o repositório de clientes",
                clientes.chamadas == 1 && trabalhadores.chamadas == 0);

        // Cadastro de trabalhador
        service.cadastrar(trabalhador("Eletricista"));
        verificar("Cadastro de trabalhador chama o repositório de trabalhadores",
                trabalhadores.chamadas == 1 && clientes.chamadas == 1);
        verificar("Tipo de trabalho chega ao repositório",
                "Eletricista".equals(trabalhadores.ultimoTipoTrabalho));

        // Cadastro inválido não pode gravar nada
        boolean lancou = lancaErro(() -> service.cadastrar(trabalhador("")));
        verificar("Cadastro inválido lança erro", lancou);
        verificar("Cadastro inválido não grava nada",
                clientes.chamadas == 1 && trabalhadores.chamadas == 1);

        // Enum
        verificar("TipoCadastro converte o texto do combo",
                TipoCadastro.doRotulo("Trabalhador") == TipoCadastro.TRABALHADOR);

        // Testes do PedidoTrabalho
        PedidoTrabalho pedido = new PedidoTrabalho(
                1,
                null,
                null,
                new TipoTrabalho(1, "Eletricista", "Serviço elétrico"),
                "Curitiba",
                150.00
        );

        pedido.cancelarPedido();

        verificar("Pedido pendente pode ser cancelado",
                "Cancelado".equals(pedido.getStatus()));

// Pedido confirmado não pode ser cancelado
        PedidoTrabalho pedidoConfirmado = new PedidoTrabalho(
                2,
                null,
                null,
                new TipoTrabalho(1, "Eletricista", "Serviço elétrico"),
                "Curitiba",
                200.00
        );

        pedidoConfirmado.confirmarPedido();

        verificar("Pedido confirmado não pode ser cancelado",
                lancaErroPedido(() -> pedidoConfirmado.cancelarPedido()));

        System.out.println(falhas == 0
                ? "\nTodos os testes passaram."
                : "\nTestes com falha: " + falhas);
    }

    private static DadosCadastro cliente() {
        return new DadosCadastro("Maria", "11122233344", "123456", "Curitiba",
                "maria@email.com", "senha123", "41999990000", TipoCadastro.CLIENTE, "");
    }

    private static DadosCadastro trabalhador(String tipoTrabalho) {
        return new DadosCadastro("João", "55566677788", "654321", "Curitiba",
                "joao@email.com", "senha456", "41988880000", TipoCadastro.TRABALHADOR, tipoTrabalho);
    }

    private static boolean lancaErro(Runnable acao) {
        try {
            acao.run();
            return false;
        } catch (DadosInvalidosException e) {
            return true;
        }
    }

    private static boolean lancaErroPedido(Runnable acao) {
        try {
            acao.run();
            return false;
        } catch (PedidoInvalidoException e) {
            return true;
        }
    }

    private static void verificar(String descricao, boolean condicao) {
        System.out.println((condicao ? "[OK]     " : "[FALHOU] ") + descricao);
        if (!condicao) {
            falhas++;
        }
    }
}
