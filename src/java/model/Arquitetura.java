package model;

import dao.ArquiteturaDAO;
import java.sql.SQLException;
import java.util.List;

public class Arquitetura {

    private int idArquitetura, FK_automovel;
    private String caminho_imagem;

    public Arquitetura(int idArquitetura, String caminho_imagem, int FK_automovel) {
        this.idArquitetura = idArquitetura;
        this.FK_automovel = FK_automovel;
        this.caminho_imagem = caminho_imagem;
    }

    public int getIdArquitetura() {
        return idArquitetura;
    }

    public void setIdArquitetura(int idArquitetura) {
        this.idArquitetura = idArquitetura;
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
