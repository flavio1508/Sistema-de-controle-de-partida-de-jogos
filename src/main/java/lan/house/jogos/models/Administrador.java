package lan.house.jogos.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
public class Administrador extends Pessoa {
   @OneToOne(mappedBy = "administrador", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Administrador(String nome, LocalDate dataDeNascimento, Genero genero, Usuario usuario)throws Exception{
        super(nome,dataDeNascimento,genero);
        setUsuario(usuario);
    }
}
