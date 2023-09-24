package lan.house.jogos.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestDTO {
    private String nomeFornecedor;
    private String descricaoFornecedor;
    private String endereco;
    private String contato;
}
