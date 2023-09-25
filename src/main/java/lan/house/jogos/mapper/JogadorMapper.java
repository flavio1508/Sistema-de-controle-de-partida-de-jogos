package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.JogadorRequestDTO;
import lan.house.jogos.dto.JogadorResponseDTO;
import lan.house.jogos.models.Jogador;

public interface JogadorMapper {
    public JogadorResponseDTO jogadorParaJogadorResponseDTO(Jogador jogador);

    public Jogador jogadorRequestParaJogador(JogadorRequestDTO jogadorRequestDTO) throws Exception;

    public Collection<JogadorResponseDTO> jogadoresParaJogadoresResponseDTOs(Collection<Jogador> jogadores);
}
