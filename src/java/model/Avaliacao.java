/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Avaliacao implements Serializable {

    @Id
    @Column(name = "idAvaliacao")
    private Integer idAvaliacao;
    private int frequencia;
    private String comparecimento;
    private String data;
    @ManyToOne
    @JoinColumn(name = "FK_integrante", referencedColumnName = "matricula")
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

    public Avaliacao(Integer idAvaliacao, int frequencia, String comparecimento, String data, Integrante fKintegrante) {
        this.idAvaliacao = idAvaliacao;
        this.frequencia = frequencia;
        this.comparecimento = comparecimento;
        this.data = data;
        this.fKintegrante = fKintegrante;
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
