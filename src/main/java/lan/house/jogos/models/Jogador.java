package lan.house.jogos.models;
import java.util.Date;

import javax.persistence.Entity;

import lan.house.jogos.utils.EntidadeBase;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Builder
public class Jogador extends EntidadeBase {
    private String nome;
    private Date dataNascimento;
    private String nickname;
    private String email;

    public Jogador(String nome, Date dataNascimento, String nickname, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nickname = nickname;
        this.email = email;
    }

   
}
