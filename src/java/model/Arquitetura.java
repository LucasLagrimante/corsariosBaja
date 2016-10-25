package model;

import dao.ArquiteturaDAO;
import java.sql.SQLException;
import java.util.List;

public class Arquitetura {

    private int idArquitetura;

    public Arquitetura(int id) {
        this.idArquitetura = id;
    }

    public int getId() {
        return idArquitetura;
    }

    public void setId(int id) {
        this.idArquitetura = id;
    }
    
   public void gravar() throws SQLException, ClassNotFoundException {
        ArquiteturaDAO.gravar(this);
    }
    
    public static List<Arquitetura> obterArquiteturas() throws ClassNotFoundException, SQLException {
        return ArquiteturaDAO.obterArquiteturas();
    }

    public static Arquitetura obterArquitetura(int idArquitetura) throws ClassNotFoundException {
        return ArquiteturaDAO.obterArquitetura(idArquitetura);
    }
}
