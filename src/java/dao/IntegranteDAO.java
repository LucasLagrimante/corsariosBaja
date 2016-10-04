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
import model.Integrante;

public class IntegranteDAO {

    public static List<Integrante> obterIntegrantes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Integrante> integrantes = new ArrayList<Integrante>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from integrante");
            while (rs.next()) {
                Integrante integrante = new Integrante(
                        rs.getInt("matricula"),
                        rs.getString("cargaHorariaDisponivel")
                );
                integrantes.add(integrante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return integrantes;
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
