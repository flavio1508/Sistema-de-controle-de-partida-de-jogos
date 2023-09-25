package lan.house.jogos.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lan.house.jogos.dto.FornecedorResponseDTO;
import lan.house.jogos.mapper.FornecedorMapper;
import lan.house.jogos.models.Fornecedor;
import lan.house.jogos.repository.FornecedorRepoditory;
import org.springframework.util.Assert;

public class FornecedorServiceTest {
      @InjectMocks
    private FornecedorService fornecedorService;

    @Mock
    private FornecedorRepoditory fornecedorRepository;

    @Mock
    private FornecedorMapper fornecedorMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarPorId() {
        // Mock the behavior of the repository and mapper
        Long id = 1L;
        Fornecedor mockFornecedor = new Fornecedor();
        mockFornecedor.setId(id);
        FornecedorResponseDTO mockResponseDTO = new FornecedorResponseDTO(mockFornecedor);

        when(fornecedorRepository.findById(id)).thenReturn(Optional.of(mockFornecedor));
        when(fornecedorMapper.fornecedorParaFornecedorResponseDTO(mockFornecedor)).thenReturn(mockResponseDTO);

        // Test the service method
        FornecedorResponseDTO responseDTO = fornecedorService.buscarPorId(id);

        // Assertions
        Assert.notNull(responseDTO, "Response should not be null");
        Assert.isTrue(responseDTO.getId().equals(id), "IDs should match");
    }

}
