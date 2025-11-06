package br.com.yure.gerenciador_projeto.presentation;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoResponseDTO;
import br.com.yure.gerenciador_projeto.application.services.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
