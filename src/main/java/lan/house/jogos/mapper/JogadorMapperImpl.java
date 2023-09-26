package lan.house.jogos.mapper;

import org.springframework.stereotype.Component;
import lan.house.jogos.dto.JogadorRequestDTO;
import lan.house.jogos.dto.JogadorResponseDTO;
import lan.house.jogos.models.Jogador;

import java.util.Collection;
import java.util.ArrayList;

@Component
public class JogadorMapperImpl implements JogadorMapper {

    @Override
    public JogadorResponseDTO jogadorParaJogadorResponseDTO(Jogador jogador) {
        return new JogadorResponseDTO(
                jogador.getId(),
                jogador.getNome(),
                jogador.getDataDeNascimento(),
                jogador.getGenero(),
                jogador.getNickname(),
                jogador.getEmail());
    }

    @Override
    public Jogador jogadorRequestParaJogador(JogadorRequestDTO jogadorRequestDTO) {
        return new Jogador(
                jogadorRequestDTO.getNome(),
                jogadorRequestDTO.getDataDeNascimento(),
                jogadorRequestDTO.getGenero(),
                jogadorRequestDTO.getNickname(),
                jogadorRequestDTO.getEmail());
    }

    @Override
    public Collection<JogadorResponseDTO> jogadoresParaJogadoresResponseDTOs(Collection<Jogador> jogadores) {
        Collection<JogadorResponseDTO> jogadoresRetornados = new ArrayList<>();

        for (Jogador jogador : jogadores) {
            jogadoresRetornados.add(jogadorParaJogadorResponseDTO(jogador));
        }
        return jogadoresRetornados;
    }
}
