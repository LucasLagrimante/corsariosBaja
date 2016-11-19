package model;

import dao.DesignDAO;
import java.sql.SQLException;
import java.util.List;

public class Design {

    private int idDesign;
    private String caminhoImagem;
    private final int idAutomovel;
    private Automovel automovel;

    public Design(int idDesign, String caminhoImagem, int idAutomovel) {
        this.idDesign = idDesign;
        this.caminhoImagem = caminhoImagem;
        this.idAutomovel = idAutomovel;
    }

    public int getIdDesign() {
        return idDesign;
    }

    public void setIdDesign(int idDesign) {
        this.idDesign = idDesign;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public Automovel getAutomovel() throws ClassNotFoundException {
        if ((automovel == null) && (idAutomovel != 0)) {
            automovel = Automovel.obterAutomovel(idAutomovel);
        }
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public int getIdAutomovel() {
        return idAutomovel;
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
