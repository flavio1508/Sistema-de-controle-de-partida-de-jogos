package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.PartidaRequestDTO;
import lan.house.jogos.dto.PartidaResponseDTO;
import lan.house.jogos.models.Partida;

public interface PartidaMapper {
    public PartidaResponseDTO partidaParaPartidaResponseDTO(Partida partida);  
    public Partida partidaRequestparaPartida(PartidaRequestDTO partidaRequestDTO) throws Exception;
    public Collection<PartidaResponseDTO> partidasParaPartidasResponsesDtos(Collection<Partida> partidas);
}
