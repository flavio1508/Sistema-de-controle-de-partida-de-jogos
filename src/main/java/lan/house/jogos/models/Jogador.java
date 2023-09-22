package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

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

    @OneToOne(mappedBy = "jogador", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Jogador(String nome, LocalDate dataNascimento, Genero genero, String nickname, Usuario usuario) throws Exception {
        super(nome, dataNascimento, genero);
        this.nickname = nickname;
        setUsuario(usuario);
    }

}
