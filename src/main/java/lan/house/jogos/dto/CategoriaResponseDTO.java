package lan.house.jogos.dto;
import lan.house.jogos.models.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaResponseDTO {
    private Long id;
    private String nomeCategoria;

    public CategoriaResponseDTO(Categoria categoria){
        this.id = categoria.getId();
        this.nomeCategoria = categoria.getNomeCategoria();
    }

}
