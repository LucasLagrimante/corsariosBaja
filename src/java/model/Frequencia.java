package model;

import dao.FrequenciaDAO;
import java.sql.SQLException;
import java.util.List;

public class Frequencia {

    private int idFrequencia, FK_integrante;
    private String data,estado;

    public Frequencia(int idFrequencia, int FK_integrante, String data, String estado) {
        this.idFrequencia = idFrequencia;
        this.FK_integrante = FK_integrante;
        this.data = data;
        this.estado = estado;
    }
    
    public int getFK_integrante() {
        return FK_integrante;
    }

    public void setFK_integrante(int FK_integrante) {
        this.FK_integrante = FK_integrante;
    }

   

    public Frequencia() {
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
    public static List<Frequencia> obterFrequencias() throws ClassNotFoundException, SQLException {
        return FrequenciaDAO.obterFrequencias();
    }

    public static Frequencia obterFrequencia(int idFrequencia) throws ClassNotFoundException {
        return FrequenciaDAO.obterFrequencia(idFrequencia);
    }
}
