/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "avaliacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByFrequencia", query = "SELECT a FROM Avaliacao a WHERE a.frequencia = :frequencia"),
    @NamedQuery(name = "Avaliacao.findByComparecimento", query = "SELECT a FROM Avaliacao a WHERE a.comparecimento = :comparecimento"),
    @NamedQuery(name = "Avaliacao.findByData", query = "SELECT a FROM Avaliacao a WHERE a.data = :data")})
public class Avaliacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAvaliacao")
    private Integer idAvaliacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frequencia")
    private int frequencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "comparecimento")
    private String comparecimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "FK_integrante", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Integrante fKintegrante;

    public Avaliacao() {
    }

    public Avaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Avaliacao(Integer idAvaliacao, int frequencia, String comparecimento, String data) {
        this.idAvaliacao = idAvaliacao;
        this.frequencia = frequencia;
        this.comparecimento = comparecimento;
        this.data = data;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public String getComparecimento() {
        return comparecimento;
    }

    public void setComparecimento(String comparecimento) {
        this.comparecimento = comparecimento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integrante getFKintegrante() {
        return fKintegrante;
    }

    public void setFKintegrante(Integrante fKintegrante) {
        this.fKintegrante = fKintegrante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
