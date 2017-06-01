/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ArquiteturaDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
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
@Table(name = "arquitetura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arquitetura.findAll", query = "SELECT a FROM Arquitetura a")
    ,
    @NamedQuery(name = "Arquitetura.findByIdArquitetura", query = "SELECT a FROM Arquitetura a WHERE a.idArquitetura = :idArquitetura")
    ,
    @NamedQuery(name = "Arquitetura.findByCaminhoImagem", query = "SELECT a FROM Arquitetura a WHERE a.caminhoImagem = :caminhoImagem")})
public class Arquitetura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idArquitetura")
    private Integer idArquitetura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "caminhoImagem")
    private String caminhoImagem;
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel fKautomovel;

    public Arquitetura() {
    }

    public Arquitetura(Integer idArquitetura) {
        this.idArquitetura = idArquitetura;
    }

    public Arquitetura(Integer idArquitetura, String caminhoImagem) {
        this.idArquitetura = idArquitetura;
        this.caminhoImagem = caminhoImagem;
    }

    public Integer getIdArquitetura() {
        return idArquitetura;
    }

    public void setIdArquitetura(Integer idArquitetura) {
        this.idArquitetura = idArquitetura;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Automovel getFKautomovel() {
        return fKautomovel;
    }

    public void setFKautomovel(Automovel fKautomovel) {
        this.fKautomovel = fKautomovel;
    }

    public static List<model.Arquitetura> obterArquiteturas() {
        return ArquiteturaDAO.obterArquiteturas();
    }

    public static model.Arquitetura obterArquitetura(int idArquitetura) {
        return ArquiteturaDAO.getArquitetura(idArquitetura);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArquitetura != null ? idArquitetura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arquitetura)) {
            return false;
        }
        Arquitetura other = (Arquitetura) object;
        if ((this.idArquitetura == null && other.idArquitetura != null) || (this.idArquitetura != null && !this.idArquitetura.equals(other.idArquitetura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Arquitetura[ idArquitetura=" + idArquitetura + " ]";
    }

}
