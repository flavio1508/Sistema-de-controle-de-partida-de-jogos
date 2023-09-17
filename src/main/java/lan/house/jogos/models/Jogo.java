package lan.house.jogos.models;

public class Jogo {
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