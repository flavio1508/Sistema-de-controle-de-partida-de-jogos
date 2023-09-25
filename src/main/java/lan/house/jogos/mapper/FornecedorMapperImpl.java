package lan.house.jogos.mapper;

import org.springframework.stereotype.Component;
import lan.house.jogos.dto.FornecedorRequestDTO;
import lan.house.jogos.dto.FornecedorResponseDTO;
import lan.house.jogos.models.Fornecedor;

import java.util.Collection;
import java.util.ArrayList;

@Component
public class FornecedorMapperImpl implements FornecedorMapper {

    @Override
    public FornecedorResponseDTO fornecedorParaFornecedorResponseDTO(Fornecedor fornecedor) {
        return new FornecedorResponseDTO(
                fornecedor.getId(),
                fornecedor.getNomeFornecedor(),
                fornecedor.getDescricaoFornecedor(),
                fornecedor.getEndereco(),
                fornecedor.getContato());
    }

    @Override
    public Fornecedor fornecedorRequestparaFornecedor(FornecedorRequestDTO fornecedorRequestDTO) {
        return new Fornecedor(
                fornecedorRequestDTO.getNomeFornecedor(),
                fornecedorRequestDTO.getDescricaoFornecedor(),
                fornecedorRequestDTO.getEndereco(),
                fornecedorRequestDTO.getContato());
    }

    @Override
    public Collection<FornecedorResponseDTO> fornecedoresParaFornecedoresResponsesDtos(Collection<Fornecedor> fornecedores) {
        Collection<FornecedorResponseDTO> fornecedoresRetornados = new ArrayList<>();

        for (Fornecedor fornecedor : fornecedores) {
            fornecedoresRetornados.add(fornecedorParaFornecedorResponseDTO(fornecedor));
        }
        return fornecedoresRetornados;
    }
}
