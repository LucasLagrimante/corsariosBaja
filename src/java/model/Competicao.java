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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lucas
 */
@Entity(name = "Competicao")
@Table(name = "competicao")
public class Competicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCompeticao")
    private Integer idCompeticao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "hora")
    private String hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "local")
    private String local;
    @JoinColumn(name = "FK_tipopista", referencedColumnName = "idTipopista")
    @ManyToOne(optional = false)
    private Tipopista fKtipopista;

    public Competicao() {
    }

    public Competicao(Integer idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public Competicao(Integer idCompeticao, String nome, String data, String hora, String local, Tipopista fKtipopista) {
        this.idCompeticao = idCompeticao;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.fKtipopista = fKtipopista;
    }

    public Competicao(Integer idCompeticao, String nome, String data, String hora, String local) {
        this.idCompeticao = idCompeticao;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
    }

    public Integer getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdCompeticao(Integer idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Tipopista getFKtipopista() {
        return fKtipopista;
    }

    public void setFKtipopista(Tipopista fKtipopista) {
        this.fKtipopista = fKtipopista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompeticao != null ? idCompeticao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competicao)) {
            return false;
        }
        Competicao other = (Competicao) object;
        if ((this.idCompeticao == null && other.idCompeticao != null) || (this.idCompeticao != null && !this.idCompeticao.equals(other.idCompeticao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Competicao[ idCompeticao=" + idCompeticao + " ]";
    }

}
