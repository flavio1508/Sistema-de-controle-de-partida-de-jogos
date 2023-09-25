package lan.house.jogos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lan.house.jogos.dto.JogoRequestDTO;
import lan.house.jogos.dto.JogoResponseDTO;
import lan.house.jogos.mapper.JogoMapper;
import lan.house.jogos.models.Jogo;
import lan.house.jogos.repository.JogoRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private JogoMapper jogoMapper;

    public JogoResponseDTO buscarPorId(Long id) {
        return jogoMapper.jogoParaJogoResponseDTO(buscarJogoPeloId(id));
    }

    private Jogo buscarJogoPeloId(Long id) {
        Optional<Jogo> jogoOptional = jogoRepository.findById(id);
        if (jogoOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return jogoOptional.get();
    }

    public JogoResponseDTO cadastrar(JogoRequestDTO jogoRequestDTO) throws Exception {
        Jogo jogo = jogoMapper.jogoRequestparaJogo(jogoRequestDTO);
        jogoRepository.save(jogo);
        return jogoMapper.jogoParaJogoResponseDTO(jogo);
    }

    public Collection<JogoResponseDTO> buscarTodos() {
        return jogoMapper.jogosParaJogosResponseDTOs((Collection<Jogo>) jogoRepository.findAll());
    }

}
