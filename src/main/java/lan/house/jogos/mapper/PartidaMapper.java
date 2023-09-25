package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.PartidaRequestDTO;
import lan.house.jogos.dto.PartidaResponseDTO;
import lan.house.jogos.models.Partida;

public interface PartidaMapper {
    PartidaResponseDTO partidaParaPartidaResponseDTO(Partida partida);

    Partida partidaRequestParaPartida(PartidaRequestDTO partidaRequestDTO) throws Exception;

    Collection<PartidaResponseDTO> partidasParaPartidasResponseDTOs(Collection<Partida> partidas);
}
