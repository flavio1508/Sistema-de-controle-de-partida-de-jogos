package lan.house.jogos.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import lan.house.jogos.dto.PartidaRequestDTO;
import lan.house.jogos.dto.PartidaResponseDTO;
import lan.house.jogos.mapper.PartidaMapper;
import lan.house.jogos.models.Partida;
import lan.house.jogos.repository.PartidaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

// Importe as classes e anotações necessárias

public class PartidaServiceTest {

    @InjectMocks
    private PartidaService partidaService;

    @Mock
    private PartidaRepository partidaRepository;

    @Mock
    private PartidaMapper partidaMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarPorId() {
        // Criar dados de teste
        Long id = 1L;
        Partida partida = new Partida();
        partida.setId(id);
        PartidaResponseDTO responseDTO = new PartidaResponseDTO(partida);

        // Configurar comportamento do mock do repositório
        when(partidaRepository.findById(id)).thenReturn(Optional.of(partida));

        // Configurar comportamento do mock do mapper
        when(partidaMapper.partidaParaPartidaResponseDTO(partida)).thenReturn(responseDTO);

        // Testar o serviço
        PartidaResponseDTO result = partidaService.buscarPorId(id);

        // Verificar se o método do repositório foi chamado
        verify(partidaRepository, times(1)).findById(id);

        // Verificar se o método do mapper foi chamado
        verify(partidaMapper, times(1)).partidaParaPartidaResponseDTO(partida);

        // Verificar se o resultado não é nulo e tem o mesmo ID
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testBuscarTodas() {
        // Criar dados de teste
        Partida partida1 = new Partida();
        Partida partida2 = new Partida();
        Collection<Partida> partidas = List.of(partida1, partida2);

        PartidaResponseDTO responseDTO1 = new PartidaResponseDTO(partida1);
        PartidaResponseDTO responseDTO2 = new PartidaResponseDTO(partida2);
        Collection<PartidaResponseDTO> responseDTOs = List.of(responseDTO1, responseDTO2);

        // Configurar comportamento do mock do repositório
        when(partidaRepository.findAll()).thenReturn((List<Partida>) partidas);

        // Configurar comportamento do mock do mapper
        when(partidaMapper.partidasParaPartidasResponseDTOs(partidas)).thenReturn(responseDTOs);

        // Testar o serviço
        Collection<PartidaResponseDTO> result = partidaService.buscarTodas();

        // Verificar se o método do repositório foi chamado
        verify(partidaRepository, times(1)).findAll();

        // Verificar se o método do mapper foi chamado
        verify(partidaMapper, times(1)).partidasParaPartidasResponseDTOs(partidas);

        // Verificar se o resultado não é nulo
        assertNotNull(result);
        // Você pode adicionar mais verificações aqui de acordo com a lógica do seu aplicativo
    }
}

