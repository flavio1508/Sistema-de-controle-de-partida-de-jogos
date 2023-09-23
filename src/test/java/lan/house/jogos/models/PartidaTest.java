// package lan.house.jogos.models;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// public class PartidaTest {
//     @Test
//     public void testIniciarPartida() throws Exception {
//         Jogo jogo = new Jogo();
//         jogo.setNome("FIFA 22");
//         jogo.setDescricao("Esportes");
//         jogo.setCategoria("EA Sports");

//         Usuario usuario1 = new Usuario("flavio@example.com", "senha", UserRole.Jogador);
//         Usuario usuario2 = new Usuario("flavio@example.com", "senha", UserRole.Jogador);

//         Jogador jogador1 = new Jogador("Flavio", LocalDate.of(1990, 1, 1), Genero.MASCULINO, "flavio123", usuario1);
//         Jogador jogador2 = new Jogador("Maria", LocalDate.of(1995, 1, 1), Genero.FEMININO, "maria456", usuario2);
        
//         List<Jogador> jogadores = new ArrayList<>();
//         jogadores.add(jogador1);
//         jogadores.add(jogador2);
        
//         Partida partida = new Partida(Status.PROGRAMADA, jogo, jogadores, LocalDate.now(), LocalDate.now());
        
//         partida.iniciarPartida(LocalDate.now()); 
        
//         assertEquals(Status.EM_ANDAMENTO, partida.getStatus(), "A partida deve estar em andamento após iniciar.");
//     }

//     @Test
//     public void testFinalizarPartida() throws Exception {
//         Jogo jogo = new Jogo();
//         jogo.setNome("FIFA 22");
//         jogo.setDescricao("Esportes");
//         jogo.setCategoria("EA Sports");

//         Usuario usuario1 = new Usuario("flavio@example.com", "senha", UserRole.Jogador);
//         Usuario usuario2 = new Usuario("maria@example.com", "senha", UserRole.Jogador);

//         Jogador jogador1 = new Jogador("Flavio", LocalDate.of(1990, 1, 1), Genero.MASCULINO, "flavio123", usuario1);
//         Jogador jogador2 = new Jogador("Maria", LocalDate.of(1995, 1, 1), Genero.FEMININO, "maria456", usuario2);
        
//         List<Jogador> jogadores = new ArrayList<>();
//         jogadores.add(jogador1);
//         jogadores.add(jogador2);
        
//         Partida partida = new Partida(Status.PROGRAMADA, jogo, jogadores, LocalDate.now(), LocalDate.now());
        
//         partida.iniciarPartida(LocalDate.now()); 
//         partida.finalizarPartida(LocalDate.now(), jogador1); 
        
//         assertEquals(Status.FINALIZADA, partida.getStatus(), "A partida deve estar finalizada após a finalização.");
//         assertEquals(jogador1, partida.getVencedor(), "O jogador 1 deve ser o vencedor.");
//     }
// }
