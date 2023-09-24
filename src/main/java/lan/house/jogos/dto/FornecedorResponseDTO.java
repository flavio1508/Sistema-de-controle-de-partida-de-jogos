package lan.house.jogos.dto;
import lan.house.jogos.models.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FornecedorResponseDTO {
    private Long id;
    private String nomeFornecedor;
    private String descricaoFornecedor;
    private String endereco;
    private String contato;

    public FornecedorResponseDTO(Fornecedor fornecedor){
        this.id = fornecedor.getId();
        this.nomeFornecedor = fornecedor.getNomeFornecedor();
        this.descricaoFornecedor = fornecedor.getDescricaoFornecedor();
        this.endereco = fornecedor.getDescricaoFornecedor();
        this.contato = fornecedor.getEndereco();
    }
}
