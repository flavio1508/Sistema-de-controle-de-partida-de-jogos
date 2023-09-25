package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Categoria;
import lan.house.jogos.models.Fornecedor;
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
    private Categoria categoria;
    private Fornecedor fornecedor;
    private Long IdDaCategoria;
}
