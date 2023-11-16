package ATIVIDADE9.mvnteste.src.test.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals; 

public class PessoaTest {

    @Test
    public void testDizerOla() {
        Pessoa pessoa = new Pessoa();
        String mensagem = pessoa.dizerOla();
        assertEquals("Olá, Mundo!", mensagem);
    }
}