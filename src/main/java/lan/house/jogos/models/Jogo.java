package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lan.house.jogos.utils.EntidadeBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jogo extends EntidadeBase {
    @Column(nullable = false, length = 200)
    private String nome;

    @Column(length = 500, nullable = true)
    private String descricao;

    @Column(nullable = false)
    private LocalDate dataDeCriacao;

    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Fornecedor fornecedor;


    public Jogo(String nome, String descricao, Categoria categoria, Fornecedor fornecedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

}