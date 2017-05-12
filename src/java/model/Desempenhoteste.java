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
@Table(name = "desempenhoteste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desempenhoteste.findAll", query = "SELECT d FROM Desempenhoteste d"),
    @NamedQuery(name = "Desempenhoteste.findByIdDesempenhoTeste", query = "SELECT d FROM Desempenhoteste d WHERE d.idDesempenhoTeste = :idDesempenhoTeste"),
    @NamedQuery(name = "Desempenhoteste.findByNome", query = "SELECT d FROM Desempenhoteste d WHERE d.nome = :nome"),
    @NamedQuery(name = "Desempenhoteste.findByData", query = "SELECT d FROM Desempenhoteste d WHERE d.data = :data"),
    @NamedQuery(name = "Desempenhoteste.findByHora", query = "SELECT d FROM Desempenhoteste d WHERE d.hora = :hora"),
    @NamedQuery(name = "Desempenhoteste.findByVelocidadeMedia", query = "SELECT d FROM Desempenhoteste d WHERE d.velocidadeMedia = :velocidadeMedia"),
    @NamedQuery(name = "Desempenhoteste.findByAceleracaoMedia", query = "SELECT d FROM Desempenhoteste d WHERE d.aceleracaoMedia = :aceleracaoMedia"),
    @NamedQuery(name = "Desempenhoteste.findByTempoPista", query = "SELECT d FROM Desempenhoteste d WHERE d.tempoPista = :tempoPista"),
    @NamedQuery(name = "Desempenhoteste.findByFrenagem", query = "SELECT d FROM Desempenhoteste d WHERE d.frenagem = :frenagem")})
public class Desempenhoteste implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDesempenhoTeste")
    private Integer idDesempenhoTeste;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
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
    @Column(name = "velocidadeMedia")
    private float velocidadeMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aceleracaoMedia")
    private float aceleracaoMedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tempoPista")
    private String tempoPista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frenagem")
    private float frenagem;
    @JoinColumn(name = "FK_motorista", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Integrante fKmotorista;
    @JoinColumn(name = "FK_tipopista", referencedColumnName = "idTipopista")
    @ManyToOne(optional = false)
    private Tipopista fKtipopista;
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel fKautomovel;

    public Desempenhoteste() {
    }

    public Desempenhoteste(Integer idDesempenhoTeste) {
        this.idDesempenhoTeste = idDesempenhoTeste;
    }

    public Desempenhoteste(Integer idDesempenhoTeste, String nome, String data, String hora, float velocidadeMedia, float aceleracaoMedia, String tempoPista, float frenagem) {
        this.idDesempenhoTeste = idDesempenhoTeste;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.velocidadeMedia = velocidadeMedia;
        this.aceleracaoMedia = aceleracaoMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
    }

    public Integer getIdDesempenhoTeste() {
        return idDesempenhoTeste;
    }

    public void setIdDesempenhoTeste(Integer idDesempenhoTeste) {
        this.idDesempenhoTeste = idDesempenhoTeste;
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

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public String getTempoPista() {
        return tempoPista;
    }

    public void setTempoPista(String tempoPista) {
        this.tempoPista = tempoPista;
    }

    public float getFrenagem() {
        return frenagem;
    }

    public void setFrenagem(float frenagem) {
        this.frenagem = frenagem;
    }

    public Integrante getFKmotorista() {
        return fKmotorista;
    }

    public void setFKmotorista(Integrante fKmotorista) {
        this.fKmotorista = fKmotorista;
    }

    public Tipopista getFKtipopista() {
        return fKtipopista;
    }

    public void setFKtipopista(Tipopista fKtipopista) {
        this.fKtipopista = fKtipopista;
    }

    public Automovel getFKautomovel() {
        return fKautomovel;
    }

    public void setFKautomovel(Automovel fKautomovel) {
        this.fKautomovel = fKautomovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesempenhoTeste != null ? idDesempenhoTeste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenhoteste)) {
            return false;
        }
        Desempenhoteste other = (Desempenhoteste) object;
        if ((this.idDesempenhoTeste == null && other.idDesempenhoTeste != null) || (this.idDesempenhoTeste != null && !this.idDesempenhoTeste.equals(other.idDesempenhoTeste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Desempenhoteste[ idDesempenhoTeste=" + idDesempenhoTeste + " ]";
    }
    
}
