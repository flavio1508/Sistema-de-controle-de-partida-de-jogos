package lan.house.jogos.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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

    @Column(nullable = false)
    private LocalDate inicioProgramado;

    @Column(nullable = false)
    private LocalDate fimProgramado;

    @Column(nullable = false)
    private Jogador vencedor;

    @Column(nullable = false)
    private LocalDate inicioReal;
    
    @Column(nullable = false)
    private LocalDate fimReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne(mappedBy = "partida")
    private Jogo jogo;

    @ManyToMany(mappedBy = "partida", cascade = CascadeType.REMOVE)
    private List<Jogador> jogadores;

    public Partida(Status status, Jogo jogo, List<Jogador> jogadores, LocalDate inicioProgramado,
            LocalDate fimProgramado) {
        this.jogo = jogo;
        this.jogadores = jogadores;
        this.status = status;
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

}
