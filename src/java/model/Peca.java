package model;

import dao.PecaDAO;
import java.sql.SQLException;
import java.util.List;

public class Peca {

    private int idPeca, quantidade;
    private String nome, modelo;
    private float precoCompra;
    private TipoPeca tipopeca;

    public Peca(int idPeca, int quantidade, String nome, String modelo, float precoCompra, TipoPeca tipopeca) {
        this.idPeca = idPeca;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
        this.tipopeca = tipopeca;
    }

    public TipoPeca getTipopeca() {
        return tipopeca;
    }

    public void setTipopeca(TipoPeca tipopeca) {
        this.tipopeca = tipopeca;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public TipoPeca gettipopeca() {
        return tipopeca;
    }

    public void settipopeca(TipoPeca tipopeca) {
        this.tipopeca = tipopeca;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public static List<Peca> obterPecas() throws ClassNotFoundException, SQLException {
        return PecaDAO.obterPecas();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PecaDAO.gravar(this);
    }

    public static Peca obterPeca(int idPeca) throws ClassNotFoundException {
        return PecaDAO.obterPeca(idPeca);
    }
}
