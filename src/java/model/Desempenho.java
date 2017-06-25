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
@Entity(name = "Desempenho")
@Table(name = "desempenho")
public class Desempenho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDesempenho")
    private Integer idDesempenho;

    public Desempenho(Integer idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem, Automovel fKautomovel, Integrante fKmotorista, Tipopista fKtipopista) {
        this.idDesempenho = idDesempenho;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
        this.fKautomovel = fKautomovel;
        this.fKmotorista = fKmotorista;
        this.fKtipopista = fKtipopista;
    }
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
    @Column(name = "aceleracaoMedia")
    private float aceleracaoMedia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "velocidadeMedia")
    private float velocidadeMedia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tempoPista")
    private String tempoPista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frenagem")
    private float frenagem;
    @JoinColumn(name = "FK_automovel", referencedColumnName = "idAutomovel")
    @ManyToOne(optional = false)
    private Automovel fKautomovel;
    @JoinColumn(name = "FK_motorista", referencedColumnName = "matricula")
    @ManyToOne(optional = false)
    private Integrante fKmotorista;
    @JoinColumn(name = "FK_tipopista", referencedColumnName = "idTipopista")
    @ManyToOne(optional = false)
    private Tipopista fKtipopista;

    public Desempenho() {
    }

    public Desempenho(Integer idDesempenho) {
        this.idDesempenho = idDesempenho;
    }

    public Desempenho(Integer idDesempenho, String nome, String data, String hora, float aceleracaoMedia, float velocidadeMedia, String tempoPista, float frenagem) {
        this.idDesempenho = idDesempenho;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.aceleracaoMedia = aceleracaoMedia;
        this.velocidadeMedia = velocidadeMedia;
        this.tempoPista = tempoPista;
        this.frenagem = frenagem;
    }

    public Integer getIdDesempenho() {
        return idDesempenho;
    }

    public void setIdDesempenho(Integer idDesempenho) {
        this.idDesempenho = idDesempenho;
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

    public float getAceleracaoMedia() {
        return aceleracaoMedia;
    }

    public void setAceleracaoMedia(float aceleracaoMedia) {
        this.aceleracaoMedia = aceleracaoMedia;
    }

    public float getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(float velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
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

    public Automovel getFKautomovel() {
        return fKautomovel;
    }

    public void setFKautomovel(Automovel fKautomovel) {
        this.fKautomovel = fKautomovel;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesempenho != null ? idDesempenho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenho)) {
            return false;
        }
        Desempenho other = (Desempenho) object;
        if ((this.idDesempenho == null && other.idDesempenho != null) || (this.idDesempenho != null && !this.idDesempenho.equals(other.idDesempenho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Desempenho[ idDesempenho=" + idDesempenho + " ]";
    }

}
