package model;

import dao.ArquiteturaDAO;
import java.sql.SQLException;
import java.util.List;

public class Arquitetura {

    private int idArquitetura;
    private String caminhoImagem;
    private final int idAutomovel;
    private Automovel automovel;

    public Arquitetura(int idArquitetura, String caminhoImagem, int idAutomovel) {
        this.idArquitetura = idArquitetura;
        this.caminhoImagem = caminhoImagem;
        this.idAutomovel = idAutomovel;

    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public int getIdAutomovel() {
        return idAutomovel;
    }

    public int getIdArquitetura() {
        return idArquitetura;
    }

    public void setIdArquitetura(int idArquitetura) {
        this.idArquitetura = idArquitetura;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ArquiteturaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ArquiteturaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ArquiteturaDAO.excluir(this);
    }

    public static List<Arquitetura> obterArquiteturas() throws ClassNotFoundException, SQLException {
        return ArquiteturaDAO.obterArquiteturas();
    }

    public static Arquitetura obterArquitetura(int idArquitetura) throws ClassNotFoundException {
        return ArquiteturaDAO.obterArquitetura(idArquitetura);
    }

}
