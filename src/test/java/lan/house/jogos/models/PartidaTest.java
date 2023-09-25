package lan.house.jogos.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PartidaTest {
    @Test
    public void criarPartida() {
        // Assuming that you use the default constructor
        Partida partida = new Partida();

        // Set the required parameters individually
        partida.setInicioProgramado(LocalDate.of(2023, 9, 30));
        partida.setFimProgramado(LocalDate.of(2023, 10, 5));
        partida.setStatus(Status.PROGRAMADA);

        assertEquals(LocalDate.of(2023, 9, 30), partida.getInicioProgramado());
        assertEquals(LocalDate.of(2023, 10, 5), partida.getFimProgramado());
        assertEquals(Status.PROGRAMADA, partida.getStatus());
    }
}
