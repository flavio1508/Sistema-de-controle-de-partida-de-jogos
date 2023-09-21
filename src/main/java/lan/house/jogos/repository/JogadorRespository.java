package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Jogador;

public interface JogadorRespository extends JpaRepository<Jogador, Long> {
    List<Jogador>findByNomeContainingIgnoreCase(String nome);

}
