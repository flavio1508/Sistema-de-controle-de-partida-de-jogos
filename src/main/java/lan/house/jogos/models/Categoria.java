package lan.house.jogos.models;

import javax.persistence.Entity;

import lan.house.jogos.utils.EntidadeBase;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Builder
public class Categoria extends EntidadeBase {
    private String nomeCategoria;

    public Categoria(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;
    }
   
}
