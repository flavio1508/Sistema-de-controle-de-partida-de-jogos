package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Jogo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JogoResponseDTO {
    private Long id;
    private String nome;
    private LocalDate dataDeCriacao;

    public JogoResponseDTO(Jogo jogo){
        this.id = jogo.getId();
        this.nome = jogo.getNome();
        this.dataDeCriacao = jogo.getDataDeCriacao();

    }
}
