package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Categoria;

public interface CategoriaRepository extends  JpaRepository<Categoria, Long> {
    List<Categoria>findByNomeContainingIgnoreCase(String nome);
    
}
