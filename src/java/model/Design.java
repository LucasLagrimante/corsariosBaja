package model;

import dao.DesignDAO;
import java.sql.SQLException;
import java.util.List;

public class Design {

    private int idDesign, FK_automovel;
    private String caminho_imagem;

    public Design(int idDesign, String caminho_imagem, int FK_automovel) {
        this.idDesign = idDesign;
        this.FK_automovel = FK_automovel;
        this.caminho_imagem = caminho_imagem;
    }

    public int getIdDesign() {
        return idDesign;
    }

    public void setIdDesign(int idDesign) {
        this.idDesign = idDesign;
    }

    public int getFK_automovel() {
        return FK_automovel;
    }

    public void setFK_automovel(int FK_automovel) {
        this.FK_automovel = FK_automovel;
    }

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
    }
    

    public int getId() {
        return idDesign;
    }

    public void setId(int id) {
        this.idDesign = id;
    }
    public void gravar() throws SQLException, ClassNotFoundException {
        DesignDAO.gravar(this);
    }
    
    public static List<Design> obterDesigns() throws ClassNotFoundException, SQLException {
        return DesignDAO.obterDesigns();
    }

    public static Design obterDesign(int idDesign) throws ClassNotFoundException {
        return DesignDAO.obterDesign(idDesign);
    }
}
