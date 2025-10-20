package br.com.yure.gerenciador_projeto.application.dto;
import br.com.yure.gerenciador_projeto.domain.entities.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String cpf, String telefone, String email, String status) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf().getNumero(), usuario.getTelefone(), usuario.getEmail(), usuario.getStatus().toString());
    }
}
