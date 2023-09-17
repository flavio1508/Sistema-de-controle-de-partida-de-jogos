package lan.house.jogos.models;
import java.util.Date;

public class Jogador {
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

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
