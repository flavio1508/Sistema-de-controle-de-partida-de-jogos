package lan.house.jogos.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

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
public class Partida extends EntidadeBase {
    private LocalDate inicioProgramado;
    private LocalDate fimProgramado;
    private Jogador vencedor;
    private LocalDate inicioReal;
    private LocalDate fimReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    private Jogo jogo;

    @ManyToMany(mappedBy = "partida", cascade = CascadeType.REMOVE)
    private List<Jogador> jogadores;

    public Partida(Jogo jogo, List<Jogador> jogadores, LocalDate inicioProgramado, LocalDate fimProgramado) {
        this.jogo = jogo;
        this.jogadores = jogadores;
        this.status = Status.PROGRAMADA;
        this.inicioProgramado = inicioProgramado;
        this.fimProgramado = fimProgramado;
    }

    public void iniciarPartida(LocalDate inicioReal) {
        if (status == Status.PROGRAMADA) {
            this.status = Status.EM_ANDAMENTO;
            this.inicioReal = inicioReal;
        }
    }

    public void finalizarPartida(LocalDate fimReal, Jogador vencedor) {
        if (status == Status.EM_ANDAMENTO) {
            this.status = Status.FINALIZADA;
            this.fimReal = fimReal;
            this.vencedor = vencedor;
        }
    }

    public Status getStatus() {
        return status;
    }

    public Jogador getVencedor() {
        return vencedor;
    }
}
