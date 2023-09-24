package lan.house.jogos.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JogadorTest {
     @Test
    public void criarJogador() {
        LocalDate dataNascimento = LocalDate.of(1990, 5, 15); // Exemplo de data de nascimento
        Jogador jogador = new Jogador("João", dataNascimento, Genero.MASCULINO, "joao123", "joao@example.com");

        assertEquals("João", jogador.getNome());
        assertEquals(dataNascimento, jogador.getDataDeNascimento());
        assertEquals(Genero.MASCULINO, jogador.getGenero());
        assertEquals("joao123", jogador.getNickname());
        assertEquals("joao@example.com", jogador.getEmail());
        assertTrue(jogador.isMaiorDe14Anos()); // Assuming the player is older than 14 years
    }
}
