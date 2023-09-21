package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lan.house.jogos.utils.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa extends EntidadeBase {
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;
    
    public Pessoa(String nome, LocalDate dataDeNascimento, Genero genero) throws Exception {
        validaDataDeNAscimento(dataDeNascimento);
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
    }
    private void validaDataDeNAscimento(LocalDate dataDeNascimetno) throws Exception {
        if (dataDeNascimetno == null) {
            throw new Exception("A data de nascimento não pode ser vazia");
        }
    }
}
