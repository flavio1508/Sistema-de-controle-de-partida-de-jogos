package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.CategoriaRequestDTO;
import lan.house.jogos.dto.CategoriaResponseDTO;
import lan.house.jogos.models.Categoria;

public interface CategoriaMapper {
    public CategoriaResponseDTO categoriaParaCateforiaResponseDTO(Categoria categoria);  
    public Categoria categoriaRequestparaCategoria(CategoriaRequestDTO categoriaRequestDTO) throws Exception;
    public Collection<CategoriaResponseDTO> categoriasParaCategoriasResponsesDtos(Collection<Categoria> categorias);
}
