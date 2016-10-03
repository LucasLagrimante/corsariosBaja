package model;

import dao.InvestidorDAO;
import java.sql.SQLException;
import java.util.List;

public class Investidor {

    private int idInvestidor;
    private float valorDoado;

    public Investidor(int id, float valorDoado) {
        this.idInvestidor = id;
        this.valorDoado = valorDoado;
    }

    public int getId() {
        return idInvestidor;
    }

    public void setId(int id) {
        this.idInvestidor = id;
    }

    public float getValorDoado() {
        return valorDoado;
    }

    public void setValorDoado(float valorDoado) {
        this.valorDoado = valorDoado;
    }

    public static List<Investidor> obterInvestidores() throws ClassNotFoundException, SQLException{
        return InvestidorDAO.obterInvestidores();
    }
}
