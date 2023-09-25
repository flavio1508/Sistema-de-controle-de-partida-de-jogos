package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.CategoriaRequestDTO;
import lan.house.jogos.dto.CategoriaResponseDTO;
import lan.house.jogos.models.Categoria;

public interface CategoriaMapper {
    public CategoriaResponseDTO categoriaParaCategoriaResponseDTO(Categoria categoria);

    public Categoria categoriaRequestParaCategoria(CategoriaRequestDTO categoriaRequestDTO) throws Exception;

    public Collection<CategoriaResponseDTO> categoriasParaCategoriasResponseDTOs(Collection<Categoria> categorias);

}
