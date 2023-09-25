package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.FornecedorRequestDTO;
import lan.house.jogos.dto.FornecedorResponseDTO;
import lan.house.jogos.models.Fornecedor;

public interface FornecedorMapper {
    public FornecedorResponseDTO fornecedorParaFornecedorResponseDTO(Fornecedor fornecedor);

    public Fornecedor fornecedorRequestparaFornecedor(FornecedorRequestDTO fornecedorRequestDTO) throws Exception;

    public Collection<FornecedorResponseDTO> fornecedoresParaFornecedoresResponsesDtos(
            Collection<Fornecedor> fornecedores);
}
