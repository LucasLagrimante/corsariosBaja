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

public class Integrante implements Serializable {
    @Id
    @Column(name = "matricula")
    private Integer matricula;
    private String cargaHorariaDisponivel;
    @ManyToOne
    @JoinColumn(name = "FK_pessoa", referencedColumnName = "idPessoa")
    private Pessoa fKpessoa;

    public Integrante() {
    }

    public Integrante(Integer matricula) {
        this.matricula = matricula;
    }

    public Integrante(Integer matricula, String cargaHorariaDisponivel) {
        this.matricula = matricula;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public Integrante(Integer matricula, String cargaHorariaDisponivel, Pessoa fKpessoa) {
        this.matricula = matricula;
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
        this.fKpessoa = fKpessoa;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCargaHorariaDisponivel() {
        return cargaHorariaDisponivel;
    }

    public void setCargaHorariaDisponivel(String cargaHorariaDisponivel) {
        this.cargaHorariaDisponivel = cargaHorariaDisponivel;
    }

    public Pessoa getFKpessoa() {
        return fKpessoa;
    }

    public void setFKpessoa(Pessoa fKpessoa) {
        this.fKpessoa = fKpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Integrante)) {
            return false;
        }
        Integrante other = (Integrante) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Integrante[ matricula=" + matricula + " ]";
    }

}
