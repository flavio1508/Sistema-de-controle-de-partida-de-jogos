package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida>findByNomeContainingIgnoreCase(String nome);

}
