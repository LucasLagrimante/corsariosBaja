package model;

import dao.AutomovelDAO;
import java.sql.SQLException;
import java.util.List;

public class Automovel {

    private int idAutomovel;
    private String cor, nome, dataTerminoProjeto;
    private int pesoCarro, pesoChassi, custoTotal;

    public Automovel(int idAutomovel, String cor, String nome, String dataTerminoProjeto, int pesoCarro, int pesoChassi, int custoTotal) {
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

    public int getPesoCarro() {
        return pesoCarro;
    }

    public void setPesoCarro(int pesoCarro) {
        this.pesoCarro = pesoCarro;
    }

    public int getPesoChassi() {
        return pesoChassi;
    }

    public void setPesoChassi(int pesoChassi) {
        this.pesoChassi = pesoChassi;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(int custoTotal) {
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

    public static Automovel obterAutomovel(int idAutomovel) throws ClassNotFoundException {
        return AutomovelDAO.obterAutomovel(idAutomovel);
    }
    
}
