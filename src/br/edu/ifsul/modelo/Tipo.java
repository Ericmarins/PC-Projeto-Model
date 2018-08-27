package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tipo")
public class Tipo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_tipo", sequenceName = "seq_tipo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_tipo",strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NotNull(message = "A descrição não pode ser nula")
    @NotBlank(message = "A descrição não pode ser em branco")
    @Length(max = 40, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao",length = 40, nullable = false)
    private String descricao;
    
    public Tipo(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Tipo other = (Tipo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
