package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Categoria;
import lan.house.jogos.models.Fornecedor;
import lan.house.jogos.models.Genero;
import lan.house.jogos.models.Jogador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JogadorResponseDTO {
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;
    private String nickname;
    private String email;
    private Categoria categoria;
    private Fornecedor fornecedor;

    public JogadorResponseDTO(Jogador jogador) {
        this.id = jogador.getId();
        this.nome = jogador.getNome();
        this.dataDeNascimento = jogador.getDataDeNascimento();
        this.genero = jogador.getGenero();
        this.nickname = jogador.getNickname();
        this.email = jogador.getEmail();
    }
}
