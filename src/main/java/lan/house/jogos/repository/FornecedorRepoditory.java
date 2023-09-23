package lan.house.jogos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lan.house.jogos.models.Fornecedor;


public interface FornecedorRepoditory extends JpaRepository<Fornecedor, Long> {
   List<Fornecedor>findByNomeContainingIgnoreCase(String nome);

}
