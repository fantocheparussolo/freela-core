package br.com.freela.test;

import br.com.freela.exception.DadosInvalidosException;
import br.com.freela.service.ValidadorCadastro;
import org.junit.Test;
import static org.junit.Assert.fail;

public class ValidadorCadastroTest {

    @Test
    public void deveAceitarContaValida() {
        ValidadorCadastro validador = new ValidadorCadastro();

        validador.validarConta("teste@email.com", "123456");
    }

    @Test
    public void deveRejeitarSenhaVazia() {
        ValidadorCadastro validador = new ValidadorCadastro();

        try {
            validador.validarConta("teste@email.com", "");
            fail("Era esperado erro para senha vazia.");
        } catch (DadosInvalidosException e) {

        }
    }
    
    @Test
public void deveRejeitarEmailNulo() {
    ValidadorCadastro validador = new ValidadorCadastro();

    try {
        validador.validarConta(null, "123456");
        fail("Era esperado erro para e-mail nulo.");
    } catch (DadosInvalidosException e) {
        // Teste passou: o e-mail nulo foi rejeitado.
    }
}
}