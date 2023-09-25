package lan.house.jogos.service;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import lan.house.jogos.dto.JogadorResponseDTO;
import lan.house.jogos.mapper.JogadorMapper;
import lan.house.jogos.models.Jogador;
import lan.house.jogos.repository.JogadorRepository;
import org.springframework.util.Assert;


@SpringBootTest
public class JogadorServiceTest {
    @InjectMocks
    private JogadorService jogadorService;

    @Mock
    private JogadorRepository jogadorRepository;

    @Mock
    private JogadorMapper jogadorMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarPorId() {
        // Mock the behavior of the repository and mapper
        Long id = 1L;
        Jogador mockJogador = new Jogador();
        mockJogador.setId(id);
        JogadorResponseDTO mockResponseDTO = new JogadorResponseDTO(mockJogador);

        when(jogadorRepository.findById(id)).thenReturn(Optional.of(mockJogador));
        when(jogadorMapper.jogadorParaJogadorResponseDTO(mockJogador)).thenReturn(mockResponseDTO);

        // Test the service method
        JogadorResponseDTO responseDTO = jogadorService.buscarPorId(id);

        // Assertions
        Assert.notNull(responseDTO, "Response should not be null");
        Assert.isTrue(responseDTO.getId().equals(id), "IDs should match");
    }

}
