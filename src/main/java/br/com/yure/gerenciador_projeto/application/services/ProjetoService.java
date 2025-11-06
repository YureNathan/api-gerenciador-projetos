package br.com.yure.gerenciador_projeto.application.services;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoResponseDTO;
import br.com.yure.gerenciador_projeto.domain.entities.Projeto;
import br.com.yure.gerenciador_projeto.domain.reposity.ProjetoRepository;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public ProjetoResponseDTO criarProjeto(ProjetoRequestDTO projetoRequestDTO){
        Projeto projeto = new Projeto(projetoRequestDTO);
        if(projeto.getDataFimPrevista().isBefore(projeto.getDataInicio())){
            throw new RuntimeException("Data inválida.");
        }
        projeto.setStatusProjeto(EnumStatusProjeto.PLANEJADO);
        projeto = projetoRepository.save(projeto);
        ProjetoResponseDTO projetoResponseDTO = new ProjetoResponseDTO(projeto);
        return projetoResponseDTO;
    }

}
