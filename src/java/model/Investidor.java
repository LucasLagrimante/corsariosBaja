package model;

import dao.InvestidorDAO;
import java.sql.SQLException;
import java.util.List;

public class Investidor {

    private int idInvestidor;
    private float valorDoado;

    public Investidor(int idInvestidor, float valorDoado, Pessoa pessoa) {
        this.idInvestidor = idInvestidor;
        this.valorDoado = valorDoado;
        this.pessoa = pessoa;
    }
    private Pessoa pessoa;
    private int idPessoa;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(int idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public float getValorDoado() {
        return valorDoado;
    }

    public void setValorDoado(float valorDoado) {
        this.valorDoado += valorDoado;
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        InvestidorDAO.gravar(this);
    }
     public void alterar() throws SQLException, ClassNotFoundException {
        InvestidorDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        InvestidorDAO.excluir(this);
    }
    public static List<Investidor> obterInvestidores() throws ClassNotFoundException, SQLException {
        return InvestidorDAO.obterInvestidores();
    }


    public static Investidor obterInvestidor(int idInvestidor) throws ClassNotFoundException {
        return InvestidorDAO.obterInvestidor(idInvestidor);
    }
}
