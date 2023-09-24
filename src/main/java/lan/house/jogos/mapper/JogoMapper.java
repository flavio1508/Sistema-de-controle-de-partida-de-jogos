package lan.house.jogos.mapper;

import java.util.Collection;

import lan.house.jogos.dto.JogoRequestDTO;
import lan.house.jogos.dto.JogoResponseDTO;
import lan.house.jogos.models.Jogo;

public interface JogoMapper {
    public JogoResponseDTO jogoParaJogoResponseDTO(Jogo jogo);  
    public Jogo jogoRequestparaJogo(JogoRequestDTO jogoRequestDTO) throws Exception;
    public Collection<JogoResponseDTO> jogosParaJogosResponsesDtos(Collection<Jogo> jogos);
}
