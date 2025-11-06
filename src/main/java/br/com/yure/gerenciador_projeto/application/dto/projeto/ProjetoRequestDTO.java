package br.com.yure.gerenciador_projeto.application.dto.projeto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ProjetoRequestDTO(@NotBlank(message = "O nome do projeto é obrigatorio!") String nome,
                                @FutureOrPresent(message = "Data do projeto não pode ser no passado.") LocalDate dataInicio,
                                @Future(message = "Data precisa ser superior a data atual.") LocalDate dataFimPrevista) {
}
