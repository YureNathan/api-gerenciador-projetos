package br.com.yure.gerenciador_projeto.application.services;

import br.com.yure.gerenciador_projeto.application.dto.UsuarioRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.UsuarioResponseDTO;
import br.com.yure.gerenciador_projeto.domain.entities.Usuario;
import br.com.yure.gerenciador_projeto.domain.reposity.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioResponseDTO::new).toList();
    }

    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario(usuarioRequestDTO);
        return new UsuarioResponseDTO(usuarioRepository.save(usuario));
    }
}
