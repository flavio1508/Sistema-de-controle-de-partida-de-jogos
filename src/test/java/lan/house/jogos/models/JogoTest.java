package lan.house.jogos.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JogoTest {
    @Test
    public void criarJogo() {
        Categoria categoria = new Categoria(); // Suponha que você tenha uma classe Categoria
        Fornecedor fornecedor = new Fornecedor(); // Suponha que você tenha uma classe Fornecedor
        Jogo jogo = new Jogo("FIFA 22", "BOLA", categoria, fornecedor);

        assertEquals("FIFA 22", jogo.getNome());
        assertEquals("BOLA", jogo.getDescricao());
        assertEquals(categoria, jogo.getCategoria());
        assertEquals(fornecedor, jogo.getFornecedor());
    }
}
