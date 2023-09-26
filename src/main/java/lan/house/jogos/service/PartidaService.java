package lan.house.jogos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lan.house.jogos.dto.PartidaRequestDTO;
import lan.house.jogos.dto.PartidaResponseDTO;
import lan.house.jogos.mapper.PartidaMapper;
import lan.house.jogos.models.Partida;
import lan.house.jogos.repository.PartidaRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private PartidaMapper partidaMapper;

    public PartidaResponseDTO buscarPorId(Long id) {
        return partidaMapper.partidaParaPartidaResponseDTO(buscarPartidaPeloId(id));
    }

    private Partida buscarPartidaPeloId(Long id) {
        Optional<Partida> partidaOptional = partidaRepository.findById(id);
        if (partidaOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return partidaOptional.get();
    }

    public PartidaResponseDTO cadastrar(PartidaRequestDTO partidaRequestDTO) throws Exception {
        Partida partida = partidaMapper.partidaRequestParaPartida(partidaRequestDTO);
        partidaRepository.save(partida);
        return partidaMapper.partidaParaPartidaResponseDTO(partida);
    }

    public Collection<PartidaResponseDTO> buscarTodas() {
        return partidaMapper.partidasParaPartidasResponseDTOs((Collection<Partida>) partidaRepository.findAll());
    }

}
