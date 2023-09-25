package lan.house.jogos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lan.house.jogos.dto.FornecedorRequestDTO;
import lan.house.jogos.dto.FornecedorResponseDTO;
import lan.house.jogos.mapper.FornecedorMapper;
import lan.house.jogos.models.Fornecedor;
import lan.house.jogos.repository.FornecedorRepoditory;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepoditory fornecedorRepository;

    @Autowired
    private FornecedorMapper fornecedorMapper;

    public FornecedorResponseDTO buscarPorId(Long id) {
        return fornecedorMapper.fornecedorParaFornecedorResponseDTO(buscarFornecedorPeloId(id));
    }

    private Fornecedor buscarFornecedorPeloId(Long id) {
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
        if (fornecedorOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return fornecedorOptional.get();
    }

    public FornecedorResponseDTO cadastrar(FornecedorRequestDTO fornecedorRequestDTO) throws Exception {
        Fornecedor fornecedor = fornecedorMapper.fornecedorRequestparaFornecedor(fornecedorRequestDTO);
        fornecedorRepository.save(fornecedor);
        return fornecedorMapper.fornecedorParaFornecedorResponseDTO(fornecedor);
    }

    public Collection<FornecedorResponseDTO> buscarTodos() {
        return fornecedorMapper.fornecedoresParaFornecedoresResponsesDtos((Collection<Fornecedor>) fornecedorRepository.findAll());
    }

    public FornecedorResponseDTO alterar(FornecedorRequestDTO fornecedorRequestDTO, Long id) {
        Fornecedor fornecedorParaAlterar = buscarFornecedorPeloId(id);
        fornecedorParaAlterar.setNomeFornecedor(fornecedorRequestDTO.getNomeFornecedor());
        fornecedorParaAlterar.setDescricaoFornecedor(fornecedorRequestDTO.getDescricaoFornecedor());
        fornecedorParaAlterar.setEndereco(fornecedorRequestDTO.getEndereco());
        fornecedorParaAlterar.setContato(fornecedorRequestDTO.getContato());

        fornecedorRepository.save(fornecedorParaAlterar);

        return fornecedorMapper.fornecedorParaFornecedorResponseDTO(fornecedorParaAlterar);
    }
}
