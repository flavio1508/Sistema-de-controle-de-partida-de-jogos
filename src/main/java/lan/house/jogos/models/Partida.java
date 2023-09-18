package lan.house.jogos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

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
  
    private Jogo jogo;
    private List<Jogador> jogadores;
    private Status status;
    private Date inicioProgramado;
    private Date fimProgramado;
    private Jogador vencedor;
    private Date inicioReal;
    private Date fimReal;

    public Partida(Jogo jogo, List<Jogador> jogadores, Date inicioProgramado, Date fimProgramado) {
        this.jogo = jogo;
        this.jogadores = jogadores;
        this.status = Status.PROGRAMADA;
        this.inicioProgramado = inicioProgramado;
        this.fimProgramado = fimProgramado;
    }

    public void iniciarPartida(Date inicioReal) {
        if (status == Status.PROGRAMADA) {
            this.status = Status.EM_ANDAMENTO;
            this.inicioReal = inicioReal;
        }
    }

    public void finalizarPartida(Date fimReal, Jogador vencedor) {
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
