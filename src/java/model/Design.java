package model;

import dao.DesignDAO;
import java.sql.SQLException;
import java.util.List;

public class Design {

    private int idDesign;
    private String imagem;
    private final int idAutomovel;
    private Automovel automovel;

    public Design(int idDesign, String imagem, int idAutomovel) {
        this.idDesign = idDesign;
        this.imagem = imagem;
        this.idAutomovel = idAutomovel;
        
    }
    
    public Automovel getAutomovel() {
        return automovel;
    }
    
    public Automovel gsetAutomovel() {
        return this.automovel = automovel;
    }
    

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }
    public int getIdAutomovel() {
        return idAutomovel;
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
