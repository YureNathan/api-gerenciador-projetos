package br.com.yure.gerenciador_projeto.application.dto.projeto;

import br.com.yure.gerenciador_projeto.domain.entities.Projeto;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusProjeto;

import java.time.LocalDate;

public record ProjetoResponseDTO(Long id, String nome, LocalDate dataInicio, LocalDate dataFimPrevista, EnumStatusProjeto statusProjeto) {
    public ProjetoResponseDTO(Projeto projeto) {
        this(projeto.getId(), projeto.getNome(), projeto.getDataInicio(), projeto.getDataFimPrevista(), projeto.getStatusProjeto());
    }
}
