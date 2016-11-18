package model;

import dao.InvestidorDAO;
import java.sql.SQLException;
import java.util.List;

public class Investidor {

    private int idInvestidor;
    private float valorDoado;
    private final int idPessoa;
    private Pessoa pessoa;

    public Investidor(int idInvestidor, float valorDoado, int idPessoa) {
        this.idInvestidor = idInvestidor;
        this.valorDoado = valorDoado;
        this.idPessoa = idPessoa;
    }
    
    public int getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(int idInvestidor) {
        this.idInvestidor = idInvestidor;
    }

    public Pessoa getPessoa() throws ClassNotFoundException{
        
        if ((pessoa == null) && (idPessoa != 0)) {
            pessoa = Pessoa.obterPessoa(idPessoa);
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public int getIdPessoa() {
        return idPessoa;
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
