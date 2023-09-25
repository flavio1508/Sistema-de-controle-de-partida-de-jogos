package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartidaRequestDTO {
    private LocalDate inicioProgramado;
    private LocalDate fimProgramado;
    private LocalDate inicioReal;
    private LocalDate fimReal;
    private Status status;
    
}
