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
import model.Automovel;

public class AutomovelDAO {

    public static List<Automovel> obterAutomoveis() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Automovel> automoveis = new ArrayList<Automovel>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from automovel");
            while (rs.next()) {
                Automovel automovel = new Automovel(
                        rs.getInt("idAutomovel"),
                        rs.getString("cor"),
                        rs.getString("nome"),
                        rs.getString("dataTerminoProjeto"),
                        rs.getFloat("pesoCarro"),
                        rs.getFloat("pesoChassi"),
                        rs.getFloat("custoTotal")
                );
                automoveis.add(automovel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return automoveis;
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
