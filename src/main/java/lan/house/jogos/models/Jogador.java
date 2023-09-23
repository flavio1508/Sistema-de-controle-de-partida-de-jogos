package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

import lan.house.jogos.utils.EntidadeBase;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Jogador extends EntidadeBase {
    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genero genero;

    @Column(nullable = true, length = 50, unique = true)
    private String nickname;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    public Jogador(String nome, LocalDate dataDeNascimento, Genero genero, String nickname, String email) throws Exception {
        validaDataDeNAscimento(dataDeNascimento);
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.nickname = nickname;
        this.email = email;
    }

    private void validaDataDeNAscimento(LocalDate dataDeNascimetno) throws Exception {
        if (dataDeNascimetno == null) {
            throw new Exception("A data de nascimento não pode ser vazia");
        }
    }
    public boolean isMaiorDe14Anos() {
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = this.dataDeNascimento;
        return dataNascimento.plusYears(14).isBefore(hoje);
    }
}
