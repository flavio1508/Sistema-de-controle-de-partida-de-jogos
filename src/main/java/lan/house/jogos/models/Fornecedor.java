package lan.house.jogos.models;

import javax.persistence.Column;
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
    @Column(nullable = false)
    private String nomeFornecedor;

    @Column(nullable = false)
    private String descricaoFornecedor;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String contato;

    public Fornecedor(String nomeFornecedor, String descricaoFornecedor, String
    endereco, String contato){
        this.nomeFornecedor = nomeFornecedor;
        this.descricaoFornecedor = descricaoFornecedor;
        this.endereco = endereco;
        this.contato = contato;
    }
}
