package model;

import dao.CofreDAO;
import java.sql.SQLException;
import java.util.List;

public class Cofre {

    private int idCofre;
    private float total;

    public Cofre(int idCofre, float total) {
        this.idCofre = idCofre;
        this.total = total;
    }

    public int getIdCofre() {
        return idCofre;
    }

    public void setIdCofre(int idCofre) {
        this.idCofre = idCofre;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float geTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void depositar(float total) {
        this.total += total;
    }

    public static List<Cofre> obterCofres() throws ClassNotFoundException, SQLException {
        return CofreDAO.obterCofres();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        CofreDAO.gravar(this);
    }

    public static Cofre obterCofre(int idCofre) throws ClassNotFoundException {
        return CofreDAO.obterCofre(idCofre);
    }
}
