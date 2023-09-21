package lan.house.jogos.models;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jogador extends Pessoa {
    @Column(nullable = true, length = 50)
    private String nickname;

    public Jogador(String nome, LocalDate dataNascimento, Genero genero, String nickname)throws Exception {
        super(nome, dataNascimento, genero);
        this.nickname = nickname;
    }

}
