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
    
    public static List<Arquitetura>obterArquiteturas() throws ClassNotFoundException, SQLException{
        return ArquiteturaDAO.obterArquiteturas();
    }

    //getArquitetura();
}
