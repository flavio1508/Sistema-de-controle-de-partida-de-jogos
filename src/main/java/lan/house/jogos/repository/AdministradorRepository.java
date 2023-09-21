package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    List<Administrador>findByNomeContainingIgnoreCase(String nome);

}
