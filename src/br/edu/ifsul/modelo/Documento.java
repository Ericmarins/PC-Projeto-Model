
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author eric_
 */
@Entity
@Table(name = "documento")
public class Documento implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_documento", sequenceName = "seq_documento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_documento", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataRevisao")
    private Calendar dataRevisao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataVersao")
    private Calendar dataVersao;
    @Column(name = "versaoAtual")
    @Lob
    private byte[] versaoAtual;
    @Column(name = "revisao")
    @Lob
    private byte[] revisao;
    @NotNull(message = "A ficha não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "ficha", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_documento_ficha"))        
    private Ficha ficha;

    public Documento() {
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
        final Documento other = (Documento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Calendar getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Calendar dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public Calendar getDataVersao() {
        return dataVersao;
    }

    public void setDataVersao(Calendar dataVersao) {
        this.dataVersao = dataVersao;
    }

    public byte[] getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(byte[] versaoAtual) {
        this.versaoAtual = versaoAtual;
    }

    public byte[] getRevisao() {
        return revisao;
    }

    public void setRevisao(byte[] revisao) {
        this.revisao = revisao;
    }
   
}
