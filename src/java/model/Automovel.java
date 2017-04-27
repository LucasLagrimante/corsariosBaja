package model;

import dao.AutomovelDAO;
import java.sql.SQLException;
import java.util.List;

public class Automovel {

    private int idAutomovel;
    private String cor, nome, dataTerminoProjeto;
    private float pesoCarro, pesoChassi, custoTotal;

    public Automovel(int idAutomovel, String cor, String nome, String dataTerminoProjeto, float pesoCarro, float pesoChassi, float custoTotal) {
        this.idAutomovel = idAutomovel;
        this.cor = cor;
        this.nome = nome;
        this.dataTerminoProjeto = dataTerminoProjeto;
        this.pesoCarro = pesoCarro;
        this.pesoChassi = pesoChassi;
        this.custoTotal = custoTotal;
    }

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public void setIdAutomovel(int idAutomovel) {
        this.idAutomovel = idAutomovel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDataTerminoProjeto() {
        return dataTerminoProjeto;
    }

    public void setDataTerminoProjeto(String dataTerminoProjeto) {
        this.dataTerminoProjeto = dataTerminoProjeto;
    }

    public float getPesoCarro() {
        return pesoCarro;
    }

    public void setPesoCarro(float pesoCarro) {
        this.pesoCarro = pesoCarro;
    }

    public float getPesoChassi() {
        return pesoChassi;
    }

    public void setPesoChassi(float pesoChassi) {
        this.pesoChassi = pesoChassi;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AutomovelDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AutomovelDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AutomovelDAO.excluir(this);
    }

    public static List<Automovel> obterAutomoveis() throws ClassNotFoundException, SQLException {
        return AutomovelDAO.obterAutomoveis();
    }

    public static List<String> obterCores() throws ClassNotFoundException, SQLException {
        return AutomovelDAO.obterCores();
    }

    public static List<String> obterPesos() throws ClassNotFoundException, SQLException {
        return AutomovelDAO.obterPesos();
    }

    public static Automovel obterAutomovel(int idAutomovel) throws ClassNotFoundException {
        return AutomovelDAO.obterAutomovel(idAutomovel);
    }

}
