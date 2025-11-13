package br.com.yure.gerenciador_projeto.application.services;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoIniciarDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoResponseDTO;
import br.com.yure.gerenciador_projeto.domain.entities.Projeto;
import br.com.yure.gerenciador_projeto.domain.reposity.ProjetoRepository;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ProjetoResponseDTO buscarPorId(Long id) {
        Projeto projeto = buscarProjeto(id);
        ProjetoResponseDTO projetoResponseDTO = new ProjetoResponseDTO(projeto);
        return projetoResponseDTO;
    }
    public ProjetoResponseDTO iniciarProjeto( Long id) {
        Projeto projeto = buscarProjeto(id);
        projeto.setStatusProjeto(EnumStatusProjeto.EM_ANDAMENTO);
        projeto = projetoRepository.save(projeto);
        ProjetoResponseDTO projetoResponseDTO = new ProjetoResponseDTO(projeto);
        return projetoResponseDTO;
    }

    private Projeto buscarProjeto(Long id) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado!"));
        return projeto;
    }

    public ProjetoResponseDTO atualizarProjeto(Long id){
        Projeto projeto = buscarProjeto(id);

        if(!projeto.getStatusProjeto().equals(EnumStatusProjeto.EM_ANDAMENTO)){
            throw new RuntimeException("Projeto não foi iniciado.");
        }
        projeto.setStatusProjeto(EnumStatusProjeto.CONCLUIDO);
        projeto = projetoRepository.save(projeto);
        ProjetoResponseDTO projetoResponseDTO = new ProjetoResponseDTO(projeto);
        return projetoResponseDTO;
    }

    public List<ProjetoResponseDTO> listarProjeto(){
        List<Projeto> projetos = projetoRepository.findAll();
        List<ProjetoResponseDTO> projetoResponseDTOS = projetos.stream()
                .map(projeto -> new ProjetoResponseDTO(projeto))
                .toList();
        return projetoResponseDTOS;
    }

    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }


}
