package model;

import dao.FrequenciaDAO;
import java.sql.SQLException;
import java.util.List;

public class Frequencia {

    private int idFrequencia;
    private String data, estado;
    private final int idIntegrante;
    private Integrante integrante;

    public Frequencia(int idFrequencia, String data, String estado, int idIntegrante) {
        this.idFrequencia = idFrequencia;
        this.data = data;
        this.estado = estado;
        this.idIntegrante = idIntegrante;
    }

    public int getIdIntegrante() {
        return idIntegrante;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public int getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(int idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        FrequenciaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        FrequenciaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        FrequenciaDAO.excluir(this);
    }

    public static List<Frequencia> obterFrequencias() throws ClassNotFoundException, SQLException {
        return FrequenciaDAO.obterFrequencias();
    }

    public static Frequencia obterFrequencia(int idFrequencia) throws ClassNotFoundException {
        return FrequenciaDAO.obterFrequencia(idFrequencia);
    }
}
