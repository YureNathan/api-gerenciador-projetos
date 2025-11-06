package br.com.yure.gerenciador_projeto.domain.reposity;

import br.com.yure.gerenciador_projeto.domain.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
