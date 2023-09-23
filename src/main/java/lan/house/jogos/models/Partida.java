package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

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

    // @ManyToOne // Mapeia vencedor como um relacionamento muitos-para-um
    // private Jogador vencedor;

    @Column(nullable = false)
    private LocalDate inicioReal;
    
    @Column(nullable = false)
    private LocalDate fimReal;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

  

    @ManyToMany(mappedBy = "partida", cascade = CascadeType.REMOVE)
    private Jogador jogadores;

    public Partida(Status status, LocalDate inicioProgramado,
            LocalDate fimProgramado) {
       
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

    public void finalizarPartida(LocalDate fimReal, Jogador jogadores) {
        if (status == Status.EM_ANDAMENTO) {
            this.status = Status.FINALIZADA;
            this.fimReal = fimReal;
            this.jogadores = jogadores;
        }
    }

}
