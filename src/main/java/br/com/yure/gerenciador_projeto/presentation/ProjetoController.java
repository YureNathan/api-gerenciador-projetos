package br.com.yure.gerenciador_projeto.presentation;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoResponseDTO;
import br.com.yure.gerenciador_projeto.application.services.ProjetoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@Tag(name = "Projeto controller", description = "Controladora responsável por gerenciar os projeto!")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping("/{id}")
    @Operation(summary = "1. buscar Projeto por Id", description = "Método para buscar um projeto por Id!")
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id) {
        ProjetoResponseDTO projetoResponseDTO = projetoService.buscarPorId(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @GetMapping
    @Operation(summary = "2. Listar todos os Projeto", description = "Método para listar todos os projeto!")
    public ResponseEntity<List<ProjetoResponseDTO>> listarProjeto() {
        List<ProjetoResponseDTO> projetoResponseDTOS = projetoService.listarProjeto();
        return ResponseEntity.ok(projetoResponseDTOS);
    }

    @PostMapping
    @Operation(summary = "3. Criar Projeto", description = "Método para criar um projeto!")
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid ProjetoRequestDTO projetoRequestDTO) {
        ProjetoResponseDTO projetoResponseDTO = projetoService.criarProjeto(projetoRequestDTO);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @PutMapping("/{id}/inicarprojeto")
    @Operation(summary = "4. Iniciar Projeto", description = "Método para iniciar um projeto!")
    public ResponseEntity<ProjetoResponseDTO> iniciarProjeto(@PathVariable Long id) {
        ProjetoResponseDTO projetoResponseDTO = projetoService.iniciarProjeto(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @PutMapping("/{id}/atualizarprojeto")
    @Operation(summary = "5. Atualizar um Projeto", description = "Método para iniciar um projeto!")
    public ResponseEntity<ProjetoResponseDTO> atualizarProjeto(@PathVariable Long id) {
        ProjetoResponseDTO projetoResponseDTO = projetoService.atualizarProjeto(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "6. Deletar um Projeto", description = "Método para deleta um projeto por Id!")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
