package br.com.yure.gerenciador_projeto.application.dto.usuario;


import br.com.yure.gerenciador_projeto.domain.entities.Usuario;

public record UsuarioResponseDto(Long id, String nome, String email, String status) {


    public UsuarioResponseDto(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatus().toString()
        );
    }
}
