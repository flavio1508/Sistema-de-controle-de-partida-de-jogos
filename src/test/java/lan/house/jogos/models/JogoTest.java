package lan.house.jogos.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JogoTest {
    @Test
    public void Criar_Jogo() {
        try {
            Jogo jogo = new Jogo("FIFA 22", "BOLA", "Esportes", "EA Sports");

            assertEquals("FIFA 22", jogo.getNome());
            assertEquals("Esportes", jogo.getCategoria());
            assertEquals("EA Sports", jogo.getFornecedor());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
