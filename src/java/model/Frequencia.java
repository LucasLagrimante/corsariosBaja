package model;

import dao.FrequenciaDAO;
import java.sql.SQLException;
import java.util.List;

public class Frequencia {

    private int idFrequencia;
    private String data, estado;

    public Frequencia(int idFrequencia, String data, String estado) {
        this.idFrequencia = idFrequencia;
        this.data = data;
        this.estado = estado;
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

    
    public static List<Frequencia>obterFrequencias() throws ClassNotFoundException, SQLException{
        return FrequenciaDAO.obterFrequencias();
    }
}
