package br.com.yure.gerenciador_projeto.application.dto.usuario;

import br.com.yure.gerenciador_projeto.domain.entities.Usuario;

public record UsuarioLogadoDto(Long id, String email) {
    public UsuarioLogadoDto(Usuario usuario) {

        this(
                usuario.getId(),
                usuario.getEmail()
        );

    }
}
