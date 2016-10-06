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
import model.Desempenho;

public class DesempenhoDAO {

    public static List<Desempenho> obterDesempenhos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Desempenho> desempenhos = new ArrayList<Desempenho>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from desempenho");
            while (rs.next()) {
                Desempenho desempenho = new Desempenho(
                        rs.getInt("idDesempenho"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getFloat("aceleracaoMedia"),
                        rs.getFloat("velocidadeMedia"),
                        rs.getFloat("tempoCorrida"),
                        rs.getFloat("frenagem")
                );
                desempenhos.add(desempenho);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return desempenhos;
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
