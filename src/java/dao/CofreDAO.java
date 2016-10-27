/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cofre;

public class CofreDAO {

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

    public static void gravar(Cofre cofre) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO cofre (idCofre , valor) VALUES (?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, cofre.getIdCofre());
            comando.setFloat(2, cofre.geTotal());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Cofre> obterCofres() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cofre> cofrees = new ArrayList<Cofre>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cofre");
            while (rs.next()) {
                Cofre cofre = new Cofre(
                   rs.getInt("idCofre"),
                    rs.getInt("total")
                );
                cofrees.add(cofre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cofrees;
    }

    public static Cofre obterCofre(int registro) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Cofre cofre = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM cofre where registro = " + registro);
            rs.first();
            cofre = new Cofre(
                    rs.getInt("idCofre"),
                    rs.getInt("total")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cofre;
    }

}
