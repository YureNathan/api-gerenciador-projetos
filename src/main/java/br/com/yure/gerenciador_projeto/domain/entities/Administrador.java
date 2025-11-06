package br.com.yure.gerenciador_projeto.domain.entities;


import br.com.yure.gerenciador_projeto.application.dto.usuario.UsuarioCriarRequestDto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("ADMIN")
@NoArgsConstructor
public class Administrador extends Usuario {
    private boolean acessoIrrestrito;

    public Administrador(UsuarioCriarRequestDto usuarioRequest) {
        super(usuarioRequest);
        this.setAcessoIrrestrito(true);
    }

}
