package lan.house.jogos.service;

import lan.house.jogos.dto.JogadorRequestDTO;
import lan.house.jogos.dto.JogadorResponseDTO;
import lan.house.jogos.mapper.JogadorMapper;
import lan.house.jogos.models.Jogador;
import lan.house.jogos.repository.JogadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorMapper jogadorMapper;

    public JogadorResponseDTO buscarPorId(Long id) {
        return jogadorMapper.jogadorParaJogadorResponseDTO(buscarJogadorPeloId(id));
    }

    private Jogador buscarJogadorPeloId(Long id) {
        Optional<Jogador> jogadorOptional = jogadorRepository.findById(id);
        if (jogadorOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        return jogadorOptional.get();
    }

    public JogadorResponseDTO cadastrar(JogadorRequestDTO jogadorRequestDTO) throws Exception {
        LocalDate dataDeNascimento = jogadorRequestDTO.getDataDeNascimento();
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(dataDeNascimento, dataAtual).getYears();

        if (idade < 14) {
            throw new IllegalArgumentException("O jogador deve ter pelo menos 14 anos de idade para se cadastrar.");
        }
        Jogador jogador = jogadorMapper.jogadorRequestParaJogador(jogadorRequestDTO);
        jogadorRepository.save(jogador);
        return jogadorMapper.jogadorParaJogadorResponseDTO(jogador);
    }

    public Collection<JogadorResponseDTO> buscarTodos() {
        return jogadorMapper.jogadoresParaJogadoresResponseDTOs(jogadorRepository.findAll());
    }

    public JogadorResponseDTO alterar(JogadorRequestDTO jogadorRequestDTO, Long id) {
        Jogador jogadorParaAlterar = buscarJogadorPeloId(id);
        jogadorParaAlterar.setNome(jogadorRequestDTO.getNome());
        jogadorParaAlterar.setGenero(jogadorRequestDTO.getGenero());
        jogadorParaAlterar.setDataDeNascimento(jogadorRequestDTO.getDataDeNascimento());
        jogadorParaAlterar.setNickname(jogadorRequestDTO.getNickname());
        jogadorParaAlterar.setEmail(jogadorRequestDTO.getEmail());
        
        jogadorRepository.save(jogadorParaAlterar);

        return jogadorMapper.jogadorParaJogadorResponseDTO(jogadorParaAlterar);
    }
}
