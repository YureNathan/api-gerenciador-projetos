package br.com.yure.gerenciador_projeto.application.dto.usuario;


import br.com.yure.gerenciador_projeto.domain.entities.Usuario;

public record UsuarioResponseDto(Long id, String nome,
                                 String telefone, String email, String status) {


    public UsuarioResponseDto(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getStatus().toString()
        );
    }
}
