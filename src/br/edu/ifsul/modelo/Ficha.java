package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "ficha")
public class Ficha implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_projeto", sequenceName = "seq_projeto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_projeto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "O semestre não pode ser nulo")
    @NotBlank(message = "O semestre não pode ser em branco")
    @Length(max = 15, message = "O semestre não pode ter mais que {max} caracteres")
    @Column(name = "semestre", length = 15, nullable = false)
    private String semestre;
    @NotNull(message = "O tema não pode ser nulo")
    @NotBlank(message = "O tema não pode ser em branco")
    @Column(name = "tema", nullable = false, columnDefinition = "text")
    private String tema;
    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Encontro> encontros = new ArrayList<>();
    @NotNull(message = "O professor não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", 
            nullable = false, 
            foreignKey = @ForeignKey(name = "fk_professor_id"))
    private Usuario professor;
    @NotNull(message = "O aluno não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", 
            nullable = false, 
            foreignKey = @ForeignKey(name = "fk_aluno_id"))
    private Usuario aluno;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_coorientador_id"))
    private Usuario coorientador;

    public Ficha() {
    }

    public void adicionarEncontro(Encontro obj){
        obj.setFicha(this);
        this.getEncontros().add(obj);
    }
    
    public void removerEncontro(int idx){
        this.getEncontros().remove(idx);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getId());
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
        final Ficha other = (Ficha) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Encontro> getEncontros() {
        return encontros;
    }

    public void setEncontros(List<Encontro> encontros) {
        this.encontros = encontros;
    }

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    public Usuario getCoorientador() {
        return coorientador;
    }

    public void setCoorientador(Usuario coorientador) {
        this.coorientador = coorientador;
    }


}
