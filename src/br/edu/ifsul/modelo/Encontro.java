
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "encontro")
public class Encontro implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_encontro", sequenceName = "seq_encontro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_encontro", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotNull(message = "Data não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "dia", nullable = false)
    private Calendar dia;
    @NotNull(message = "Data não pode ser nula")
    @Column(name = "inicial", nullable = false, columnDefinition = "time")
    private Calendar horaInicial;
    @NotNull(message = "O campo assuntos não pode ser nulo")
    @NotBlank(message = "O campo assuntos não pode ser em branco")
    @Column(name = "assuntos", nullable = false, columnDefinition = "text")
    private String assuntos;
    @NotNull(message = "Data não pode ser nula")
    @Column(name = "final", nullable = false, columnDefinition = "time")
    private Calendar horaFinal;
    @NotNull(message = "A ficha não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "ficha", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_encontro_ficha"))        
    private Ficha ficha;

    public Encontro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.getId());
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
        final Encontro other = (Encontro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Calendar getDia() {
        return dia;
    }

    public void setDia(Calendar dia) {
        this.dia = dia;
    }

    public Calendar getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(Calendar horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(String assuntos) {
        this.assuntos = assuntos;
    }

    public Calendar getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Calendar horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
   
}
