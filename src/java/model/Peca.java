package model;

import dao.PecaDAO;
import java.sql.SQLException;
import java.util.List;

public class Peca {

    private int idPeca, quantidade;
    private String nome, modelo;

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getQuantidade() {
        return quantidade;
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
    private float precoCompra;

    public Peca(int id, int quantidade, String nome, String modelo, float precoCompra) {
        this.idPeca = id;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
    }


public static List<Peca> obterPecas() throws ClassNotFoundException, SQLException{
        return PecaDAO.obterPecas();
    }
}
