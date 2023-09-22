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
public class Jogo extends EntidadeBase {
    @Column(nullable = false, length = 200)
    private String nome;

    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(nullable = false, length = 200)
    private String categoria;

    @Column(nullable = false, length = 200)
    private String fornecedor;

    public Jogo(String nome, String descricao, String categoria, String fornecedor){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

 
}