package lan.house.jogos.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lan.house.jogos.models.UserRole;
import lan.house.jogos.models.Usuario;

@DataJpaTest
public class UsuarioRepositoryTest{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        usuarioRepository.deleteAll();
    }

    @Test
    void deve_obter_usuario_por_email_e_senha() throws Exception {
        // Configuração
        Usuario usuario = new Usuario("teste@gmail.com", "senha123", UserRole.Administrador);
        usuarioRepository.save(usuario);

        // Ação
        Optional<Usuario> usuarioEncontrado = usuarioRepository.obterPorEmailESenha("teste@gmail.com", "senha123");

        // Verificação
        assertThat(usuarioEncontrado).isPresent();
        assertThat(usuarioEncontrado.get().getEmail()).isEqualTo("teste@gmail.com");
    }

    @Test
    void nao_deve_encontrar_usuario_com_senha_incorreta() throws Exception {
        // Configuração
        Usuario usuario = new Usuario("teste@gmail.com", "senha123", UserRole.Administrador);
        usuarioRepository.save(usuario);

        // Ação
        Optional<Usuario> usuarioEncontrado = usuarioRepository.obterPorEmailESenha("teste@gmail.com", "senha_errada");

        // Verificação
        assertThat(usuarioEncontrado).isEmpty();
    }

    @Test
    void nao_deve_encontrar_usuario_com_email_inexistente() throws Exception {
        // Ação
        Optional<Usuario> usuarioEncontrado = usuarioRepository.obterPorEmailESenha("nao_existe@gmail.com", "senha123");

        // Verificação
        assertThat(usuarioEncontrado).isEmpty();
    }
}

