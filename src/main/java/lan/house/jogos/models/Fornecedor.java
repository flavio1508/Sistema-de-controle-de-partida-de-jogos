package lan.house.jogos.models;

import javax.persistence.Entity;

import lan.house.jogos.utils.EntidadeBase;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Builder
public class Fornecedor extends EntidadeBase {
    private String nomeFornecedor;
    private String descricaoFornecedor;
    private String endereco;
    private String contato;

    public Fornecedor(String nomeFornecedor, String descricaoFornecedor, String
    endereco, String contato){
        this.nomeFornecedor = nomeFornecedor;
        this.descricaoFornecedor = descricaoFornecedor;
        this.endereco = endereco;
        this.contato = contato;
    }
}
