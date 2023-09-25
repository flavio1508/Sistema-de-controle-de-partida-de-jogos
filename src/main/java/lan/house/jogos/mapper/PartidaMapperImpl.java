package lan.house.jogos.mapper;

import lan.house.jogos.dto.PartidaRequestDTO;
import lan.house.jogos.dto.PartidaResponseDTO;
import lan.house.jogos.models.Partida;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class PartidaMapperImpl implements PartidaMapper {

    @Override
    public PartidaResponseDTO partidaParaPartidaResponseDTO(Partida partida) {
        return new PartidaResponseDTO(partida.getId(),
                partida.getInicioProgramado(),
                partida.getFimProgramado(),
                partida.getInicioReal(),
                partida.getFimReal(),
                partida.getStatus());
    }

    @Override
    public Partida partidaRequestParaPartida(PartidaRequestDTO partidaRequestDTO) throws Exception {
        // You can create a new Partida object based on the request DTO data
        return new Partida(partidaRequestDTO.getStatus(),
                partidaRequestDTO.getInicioProgramado(),
                partidaRequestDTO.getFimProgramado());
    }

    @Override
    public Collection<PartidaResponseDTO> partidasParaPartidasResponseDTOs(Collection<Partida> partidas) {
        List<PartidaResponseDTO> partidasResponseDTOs = new ArrayList<>();
        for (Partida partida : partidas) {
            partidasResponseDTOs.add(partidaParaPartidaResponseDTO(partida));
        }
        return partidasResponseDTOs;
    }
}
