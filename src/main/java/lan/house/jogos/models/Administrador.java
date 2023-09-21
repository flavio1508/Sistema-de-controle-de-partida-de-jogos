package lan.house.jogos.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
// @NoArgsConstructor
// @AllArgsConstructor
@Builder
public class Administrador extends Pessoa {
   
}
