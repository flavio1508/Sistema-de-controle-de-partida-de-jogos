package lan.house.jogos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime inicioProgramado;
    private LocalDateTime fimProgramado;
    private LocalDateTime inicioReal;
    private LocalDateTime fimReal;
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
