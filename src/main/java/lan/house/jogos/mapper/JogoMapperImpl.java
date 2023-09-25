package lan.house.jogos.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lan.house.jogos.dto.JogoRequestDTO;
import lan.house.jogos.dto.JogoResponseDTO;
import lan.house.jogos.models.Categoria;
import lan.house.jogos.models.Jogo;
import lan.house.jogos.repository.CategoriaRepository;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ArrayList;

@Component
public class JogoMapperImpl implements JogoMapper {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public JogoResponseDTO jogoParaJogoResponseDTO(Jogo jogo) {
        return new JogoResponseDTO(
                jogo.getId(),
                jogo.getNome(),
                jogo.getDataDeCriacao());
    }

    @Override
    public Jogo jogoRequestparaJogo(JogoRequestDTO jogoRequestDTO) {
        Categoria categoria = verificaSeObjetoEhNulo(jogoRequestDTO);

        return new Jogo(
                jogoRequestDTO.getNome(),
                jogoRequestDTO.getDescricao(),
                jogoRequestDTO.getDataDeCriacao(),
                categoria, 
                null);
    }

   private Categoria verificaSeObjetoEhNulo(JogoRequestDTO jogoRequestDTO) {
        Categoria categoria;
        Optional<Categoria> categoriaOptional = categoriaRepository
                .findById(jogoRequestDTO.getIdDaCategoria());
        if (categoriaOptional.isEmpty()) {
            throw new NoSuchElementException();
        }
        categoria = categoriaOptional.get();
        return categoria;
    }

    @Override
    public Collection<JogoResponseDTO> jogosParaJogosResponseDTOs(Collection<Jogo> jogos) {
        Collection<JogoResponseDTO> jogosRetornados = new ArrayList<>();

        for (Jogo jogo : jogos) {
            jogosRetornados.add(jogoParaJogoResponseDTO(jogo));
        }
        return jogosRetornados;
    }
}
