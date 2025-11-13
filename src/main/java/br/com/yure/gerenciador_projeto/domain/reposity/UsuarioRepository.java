package br.com.yure.gerenciador_projeto.domain.reposity;


import br.com.yure.gerenciador_projeto.domain.entities.Usuario;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

   boolean existsUsuarioByEmailContainingAndSenha(String email, String senha);


    Optional<Usuario> findByEmail(String email);


    // 1. findById ignorando status = EXCLUIDO
    Optional<Usuario> findByIdAndStatusNot(Long id, EnumStatusUsuario status);

    // 2. findAll ignorando status = EXCLUIDO
    List<Usuario> findAllByStatusNot(EnumStatusUsuario status);


}
