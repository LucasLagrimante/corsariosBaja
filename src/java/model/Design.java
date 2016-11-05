package model;

import dao.DesignDAO;
import java.sql.SQLException;
import java.util.List;

public class Design {

    private int idDesign;
    private String imagem;

    public Design(int idDesign, String imagem) {
        this.idDesign = idDesign;
        this.imagem = imagem;
    }

    public int getIdDesign() {
        return idDesign;
    }

    public void setIdDesign(int idDesign) {
        this.idDesign = idDesign;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        DesignDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        DesignDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        DesignDAO.excluir(this);
    }

    public static List<Design> obterDesigns() throws ClassNotFoundException, SQLException {
        return DesignDAO.obterDesigns();
    }

    public static Design obterDesign(int idDesign) throws ClassNotFoundException {
        return DesignDAO.obterDesign(idDesign);
    }
}
