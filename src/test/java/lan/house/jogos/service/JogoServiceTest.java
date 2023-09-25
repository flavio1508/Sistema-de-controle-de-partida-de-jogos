package lan.house.jogos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lan.house.jogos.dto.JogoRequestDTO;
import lan.house.jogos.dto.JogoResponseDTO;
import lan.house.jogos.mapper.JogoMapper;
import lan.house.jogos.models.Jogo;
import lan.house.jogos.repository.JogoRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

// Importe as classes e anotações necessárias

public class JogoServiceTest {

    @InjectMocks
    private JogoService jogoService;

    @Mock
    private JogoRepository jogoRepository;

    @Mock
    private JogoMapper jogoMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarPorId() {
        // Criar dados de teste
        Long id = 1L;
        Jogo jogo = new Jogo();
        jogo.setId(id);
        JogoResponseDTO responseDTO = new JogoResponseDTO(jogo);

        // Configurar comportamento do mock do repositório
        when(jogoRepository.findById(id)).thenReturn(Optional.of(jogo));

        // Configurar comportamento do mock do mapper
        when(jogoMapper.jogoParaJogoResponseDTO(jogo)).thenReturn(responseDTO);

        // Testar o serviço
        JogoResponseDTO result = jogoService.buscarPorId(id);

        // Verificar se o método do repositório foi chamado
        verify(jogoRepository, times(1)).findById(id);

        // Verificar se o método do mapper foi chamado
        verify(jogoMapper, times(1)).jogoParaJogoResponseDTO(jogo);

        // Verificar se o resultado não é nulo e tem o mesmo ID
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testBuscarTodos() {
        // Criar dados de teste
        Jogo jogo1 = new Jogo();
        Jogo jogo2 = new Jogo();
        Collection<Jogo> jogos = List.of(jogo1, jogo2);

        JogoResponseDTO responseDTO1 = new JogoResponseDTO(jogo1);
        JogoResponseDTO responseDTO2 = new JogoResponseDTO(jogo2);
        Collection<JogoResponseDTO> responseDTOs = List.of(responseDTO1, responseDTO2);

        // Configurar comportamento do mock do repositório
        when(jogoRepository.findAll()).thenReturn((List<Jogo>) jogos);

        // Configurar comportamento do mock do mapper
        when(jogoMapper.jogosParaJogosResponseDTOs(jogos)).thenReturn(responseDTOs);

        // Testar o serviço
        Collection<JogoResponseDTO> result = jogoService.buscarTodos();

        // Verificar se o método do repositório foi chamado
        verify(jogoRepository, times(1)).findAll();

        // Verificar se o método do mapper foi chamado
        verify(jogoMapper, times(1)).jogosParaJogosResponseDTOs(jogos);

        // Verificar se o resultado não é nulo
        assertNotNull(result);
        // Você pode adicionar mais verificações aqui de acordo com a lógica do seu aplicativo
    }
}

