package br.com.yure.gerenciador_projeto.domain.entities;

import br.com.yure.gerenciador_projeto.application.dto.UsuarioRequestDTO;
import br.com.yure.gerenciador_projeto.domain.valueobjects.CPF;
import br.com.yure.gerenciador_projeto.domain.valueobjects.EnumStatusUsuario;
import jakarta.persistence.*;
import java.util.List;

// banco de dados (tabela)
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    @Embedded
    private CPF cpf;
    private String email;
    private String telefone;
    private EnumStatusUsuario status = EnumStatusUsuario.ATIVO;
    @OneToMany
    @JoinColumn(name = "usuario_id", nullable = false)
    private List<Menu>menuacesso;
    public Usuario(){}
    public Usuario(UsuarioRequestDTO usuarioRequestDTO) {
        this.email = usuarioRequestDTO.email();
        this.senha = usuarioRequestDTO.senha();
        this.nome = usuarioRequestDTO.nome();
        this.cpf =  new CPF(usuarioRequestDTO.cpf());
    }

    public Usuario(Long id, String nome, String senha, CPF cpf, String email, String telefone, EnumStatusUsuario status, List<Menu> menuacesso) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
        this.menuacesso = menuacesso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnumStatusUsuario getStatus() {
        return status;
    }

    public void setStatus(EnumStatusUsuario status) {
        this.status = status;
    }

    public List<Menu> getMenuacesso() {
        return menuacesso;
    }

    public void setMenuacesso(List<Menu> menuacesso) {
        this.menuacesso = menuacesso;
    }
}

