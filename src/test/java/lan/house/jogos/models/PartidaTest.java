package lan.house.jogos.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PartidaTest {
    @Test
    public void testIniciarPartida() {
        Jogo jogo = new Jogo("FIFA 22", "Esportes", "EA Sports");
        Jogador jogador1 = new Jogador("João", new Date(), "joao123", "joao@example.com");
        Jogador jogador2 = new Jogador("Maria", new Date(), "maria456", "maria@example.com");
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        Partida partida = new Partida(jogo, jogadores, new Date(), new Date());
        
        partida.iniciarPartida(new Date()); // Iniciar a partida
        
        assertEquals(Partida.Status.EM_ANDAMENTO, partida.getStatus());
    }

    @Test
    public void testFinalizarPartida() {
        Jogo jogo = new Jogo("FIFA 22", "Esportes", "EA Sports");
        Jogador jogador1 = new Jogador("João", new Date(), "joao123", "joao@example.com");
        Jogador jogador2 = new Jogador("Maria", new Date(), "maria456", "maria@example.com");
        List<Jogador> jogadores = new ArrayList<>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);
        Partida partida = new Partida(jogo, jogadores, new Date(), new Date());
        
        partida.iniciarPartida(new Date()); // Iniciar a partida
        partida.finalizarPartida(new Date(), jogador1); // Finalizar a partida
        
        assertEquals(Partida.Status.FINALIZADA, partida.getStatus());
        assertEquals(jogador1, partida.getVencedor());
    }
}
