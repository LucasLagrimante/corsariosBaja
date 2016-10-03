package model;

import dao.DesignDAO;
import java.sql.SQLException;
import java.util.List;

public class Design {

    private int idDesign;

    public Design(int id) {
        this.idDesign = id;
    }

    public int getId() {
        return idDesign;
    }

    public void setId(int id) {
        this.idDesign = id;
    }

    public static List<Design>obterDesigns() throws ClassNotFoundException, SQLException{
        return DesignDAO.obterDesigns();
    }
}
