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

public class Frequencia implements Serializable {
    @Id
    @Column(name = "idFrequencia")
    private Integer idFrequencia;
    private String data;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "FK_integrante", referencedColumnName = "matricula")
    private Integrante fKintegrante;

    public Frequencia() {
    }

    public Frequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public Frequencia(Integer idFrequencia, String data, String estado, Integrante fKintegrante) {
        this.idFrequencia = idFrequencia;
        this.data = data;
        this.estado = estado;
        this.fKintegrante = fKintegrante;
    }

    public Frequencia(Integer idFrequencia, String data, String estado) {
        this.idFrequencia = idFrequencia;
        this.data = data;
        this.estado = estado;
    }

    public Integer getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(Integer idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        hash += (idFrequencia != null ? idFrequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Frequencia)) {
            return false;
        }
        Frequencia other = (Frequencia) object;
        if ((this.idFrequencia == null && other.idFrequencia != null) || (this.idFrequencia != null && !this.idFrequencia.equals(other.idFrequencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Frequencia[ idFrequencia=" + idFrequencia + " ]";
    }

}
