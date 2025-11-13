package br.com.yure.gerenciador_projeto.presentation;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoResponseDTO;
import br.com.yure.gerenciador_projeto.application.services.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> criarProjeto(@RequestBody @Valid ProjetoRequestDTO projetoRequestDTO){
       ProjetoResponseDTO projetoResponseDTO = projetoService.criarProjeto(projetoRequestDTO);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id){
        ProjetoResponseDTO projetoResponseDTO = projetoService.buscarPorId(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @PutMapping("/{id}/inicarprojeto")
    public ResponseEntity<ProjetoResponseDTO> iniciarProjeto(@PathVariable Long id){
        ProjetoResponseDTO projetoResponseDTO = projetoService.iniciarProjeto(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @PutMapping("/{id}/atualizarprojeto")
    public ResponseEntity<ProjetoResponseDTO> atualizarProjeto(@PathVariable Long id){
        ProjetoResponseDTO projetoResponseDTO = projetoService.atualizarProjeto(id);
        return ResponseEntity.ok(projetoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List <ProjetoResponseDTO>> listarProjeto(){
        List<ProjetoResponseDTO> projetoResponseDTOS = projetoService.listarProjeto();
        return ResponseEntity.ok(projetoResponseDTOS);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }
}
