package br.com.yure.gerenciador_projeto.presentation;

import br.com.yure.gerenciador_projeto.application.dto.UsuarioRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.UsuarioResponseDTO;
import br.com.yure.gerenciador_projeto.application.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioRequestDTO));
    }
}
