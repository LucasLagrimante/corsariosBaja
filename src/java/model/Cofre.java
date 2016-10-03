package model;

import dao.CofreDAO;
import java.sql.SQLException;
import java.util.List;

public class Cofre {

    private int idCofre;
    private float total;

    public Cofre(int id, float total) {
        this.idCofre = id;
        this.total = total;
    }

    public Cofre(int id) {
        this.idCofre = id;
    }

    public int getId() {
        return idCofre;
    }

    public void setId(int id) {
        this.idCofre = id;
    }

    public float geTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void depositar(float valor) {
        this.total = total + valor;
    }
    
    public static List<Cofre>obterCofres() throws ClassNotFoundException, SQLException{
        return CofreDAO.obterCofres();
    }
}
