package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo>findByNomeContainingIgnoreCase(String nome);

}
