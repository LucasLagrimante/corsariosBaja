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
import model.Cofre;

public class CofreDAO {

    public static List<Cofre> obterCofres() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cofre> cofres = new ArrayList<Cofre>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cofre");
            while (rs.next()) {
                Cofre cofre = new Cofre(
                        rs.getInt("idCofre"),
                        rs.getFloat("valor")
                );
                cofres.add(cofre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cofres;
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
