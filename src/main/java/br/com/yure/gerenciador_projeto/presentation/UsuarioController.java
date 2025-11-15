package br.com.yure.gerenciador_projeto.presentation;

import br.com.yure.gerenciador_projeto.application.dto.usuario.UsuarioCriarRequestDto;
import br.com.yure.gerenciador_projeto.application.dto.usuario.UsuarioResponseDto;
import br.com.yure.gerenciador_projeto.application.services.UsuarioService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios controller", description = "Controladora responsavel por gerenciar os usuarios!")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    @Operation(summary = "1. Consulta de usuario por ID", description = "Médoto responsavel por consultar um unico usuario por ID e se não existir retorna null!")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {

            var usuario = usuarioService.buscarPorId(id);

            if (usuario == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(usuario);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "2. Listar todos", description = "Método para listar todos os usuários!")
    public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @PostMapping
    @Operation(summary = "3. Criar usuario", description = "Metodo resposavel por criar usuário")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioCriarRequestDto usuario) {

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    @Operation(summary = "4. Atualizar usuario", description = "Metodo resposavel por atualizar usuário")
    public ResponseEntity<?> atulizarUsuario(@PathVariable Long id, @RequestBody UsuarioCriarRequestDto usuario) {

        try {
            var usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/bloquear")
    @Operation(summary = "5. Bloquear de usuário!", description = "Método responsavel por Bloquear um usuario")
    public ResponseEntity<?> atualizarBloquear(@PathVariable Long id) {

        return usuarioService.bloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/desbloquear")
    @Operation(summary = "6. Desbloquear de usuário!", description = "Método responsavel por Desbloquear um usuario")
    public ResponseEntity<?> atualizarDesbloquear(@PathVariable Long id) {

        return usuarioService.desbloquearUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "7. Delete de usuário!", description = "Método responsavel por deletar um usuario")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        return usuarioService.excluirUsuario(id) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }


}