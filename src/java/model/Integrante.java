/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.IntegranteDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "integrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Integrante.findAll", query = "SELECT i FROM Integrante i")
    ,
    @NamedQuery(name = "Integrante.findByMatricula", query = "SELECT i FROM Integrante i WHERE i.matricula = :matricula")
    ,
    @NamedQuery(name = "Integrante.findByCargaHorariaDisponivel", query = "SELECT i FROM Integrante i WHERE i.cargaHorariaDisponivel = :cargaHorariaDisponivel")
    ,
    @NamedQuery(name = "Integrante.findByFKpessoa", query = "SELECT i FROM Integrante i WHERE i.fKpessoa = :fKpessoa")})
public class Integrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private Integer matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cargaHorariaDisponivel")
    private String cargaHorariaDisponivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_pessoa")
    private int fKpessoa;
    
    public Integrante() {
    }

    public Integrante(Integer matricula) {
        this.matricula = matricula;
    }

    public Integrante(Integer matricula, String cargaHorariaDisponivel, int fKpessoa) {
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

    public int getFKpessoa() {
        return fKpessoa;
    }

    public void setFKpessoa(int fKpessoa) {
        this.fKpessoa = fKpessoa;
    }

    public static List<model.Integrante> obterIntegrantes() throws ClassNotFoundException, SQLException {
        return IntegranteDAO.obterIntegrantes();
    }

    public static List<Integrante> obterPessoas() throws ClassNotFoundException, SQLException {
        return IntegranteDAO.obterPessoas();
    }

    public static model.Integrante obterIntegrante(int matricula) throws ClassNotFoundException {
        return IntegranteDAO.getIntegrante(matricula);
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
