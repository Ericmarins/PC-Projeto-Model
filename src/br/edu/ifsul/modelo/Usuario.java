package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_usuario", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O nome de usuário não pode ser nulo")
    @NotBlank(message = "O nome de usuário não pode ser em branco")
    @Length(max = 50, message = "O nome de usuário não pode ter mais que {max} caracteres")    
    @Column(name = "usuario", length = 20, nullable = false, unique = true)
    private String user;
    @NotNull(message = "A senha não pode ser nulo")
    @NotBlank(message = "A senha não pode ser em branco")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")    
    @Column(name = "senha", length = 20, nullable = false) 
    private String senha;
    @NotNull(message = "Campo professor não pode ser nulo")
    @Column(name = "professor", nullable = false)
    private Boolean professor;
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)    
    private String nome;
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser em branco")
    @Length(max = 50, message = "O email não pode ter mais que {max} caracteres")
    @Column(name = "email", length = 50, nullable = false)    
    private String email;
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser em branco")
    @Length(max = 11, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 11, nullable = false)    
    private String telefone;
    @ManyToMany
    @JoinTable(name = "permissoes",
            joinColumns
            = @JoinColumn(name = "usuario", referencedColumnName = "usuario", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "permissao", referencedColumnName = "nome", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_permissoes",
                        columnNames = {"usuario", "permissao"})})
    private List<Permissao> permissoes = new ArrayList<>();        

    public Usuario(){
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Boolean getProfessor() {
        return professor;
    }

    public void setProfessor(Boolean professor) {
        this.professor = professor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
