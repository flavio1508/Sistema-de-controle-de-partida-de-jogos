package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Partida;
import lan.house.jogos.models.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartidaResponseDTO {
    private Long id;
    private LocalDate inicioProgramado;
    private LocalDate fimProgramado;
    private LocalDate inicioReal;
    private LocalDate fimReal;
    private Status status;

    public PartidaResponseDTO(Partida partida){
        this.id = partida.getId();
        this.inicioProgramado = partida.getInicioProgramado();
        this.fimProgramado = partida.getFimProgramado();
        this.inicioReal = partida.getInicioReal();
        this.fimReal = partida.getFimReal();
        this.status = partida.getStatus();
    }
}
