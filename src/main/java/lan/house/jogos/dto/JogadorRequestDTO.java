package lan.house.jogos.dto;

import java.time.LocalDate;

import lan.house.jogos.models.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogadorRequestDTO {
    private String nome;
    private String dataDeNascimento;
    private Genero genero;
    private String nickname;
    private String email;
    

}
