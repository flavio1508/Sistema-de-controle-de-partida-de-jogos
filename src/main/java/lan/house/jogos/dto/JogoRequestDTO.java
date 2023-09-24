package lan.house.jogos.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogoRequestDTO {
    private String nome;
    private String descricao;
    private LocalDate dataDeCriacao;
}
