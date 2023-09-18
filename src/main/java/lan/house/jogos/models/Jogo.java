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
public class Jogo extends EntidadeBase {
    private String nome;
    private String categoria;
    private String fornecedor;

    public Jogo(String nome, String categoria, String fornecedor) {
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFornecedor() {
        return fornecedor;
    }
}