package br.com.yure.gerenciador_projeto.domain.entities;

import br.com.yure.gerenciador_projeto.application.dto.projeto.ProjetoRequestDTO;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusProjeto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFimPrevista;
    private EnumStatusProjeto statusProjeto;

    public Projeto(ProjetoRequestDTO projetoRequestDTO){
        this.nome = projetoRequestDTO.nome();
        this.dataInicio = projetoRequestDTO.dataInicio();
        this.dataFimPrevista = projetoRequestDTO.dataFimPrevista();

    }

}
