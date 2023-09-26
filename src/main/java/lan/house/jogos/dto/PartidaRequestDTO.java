package lan.house.jogos.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lan.house.jogos.models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaRequestDTO {
    private LocalDateTime inicioProgramado;
    private LocalDateTime fimProgramado;
    private LocalDateTime inicioReal;
    private LocalDateTime fimReal;
    private Status status;
    
}
