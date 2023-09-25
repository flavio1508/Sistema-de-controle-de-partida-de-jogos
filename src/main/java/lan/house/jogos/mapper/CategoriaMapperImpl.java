package lan.house.jogos.mapper;

import org.springframework.stereotype.Component;
import lan.house.jogos.dto.CategoriaRequestDTO;
import lan.house.jogos.dto.CategoriaResponseDTO;
import lan.house.jogos.models.Categoria;
import java.util.Collection;
import java.util.ArrayList;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaResponseDTO categoriaParaCategoriaResponseDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNomeCategoria());
    }

    @Override
    public Categoria categoriaRequestParaCategoria(CategoriaRequestDTO categoriaRequestDTO) {
        return new Categoria(categoriaRequestDTO.getNomeCategoria());
    }

    @Override
    public Collection<CategoriaResponseDTO> categoriasParaCategoriasResponseDTOs(Collection<Categoria> categorias) {
        Collection<CategoriaResponseDTO> categoriasRetornadas = new ArrayList<>();

        for (Categoria categoria : categorias) {
            categoriasRetornadas.add(categoriaParaCategoriaResponseDTO(categoria));
        }
        return categoriasRetornadas;
    }
}
