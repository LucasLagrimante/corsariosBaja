/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Frequencia;

public class FrequenciaDAO {

    public static List<Frequencia> obterFrequencias() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Frequencia> frequencias = new ArrayList<Frequencia>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from frequencia");
            while (rs.next()) {
                Frequencia frequencia = new Frequencia(
                        rs.getInt("idFrequencia"),
                        rs.getString("data"),
                        rs.getString("estado")
                );
                frequencias.add(frequencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return frequencias;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {
        }
    }

}
