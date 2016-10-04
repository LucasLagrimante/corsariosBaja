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
import model.DesempenhoTeste;

public class DesempenhoTesteDAO {

    public static List<DesempenhoTeste> obterDesempenhosTestes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<DesempenhoTeste> desempenhosTestes = new ArrayList<DesempenhoTeste>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from desempenhoTeste");
            while (rs.next()) {
                DesempenhoTeste desempenhoTeste = new DesempenhoTeste(
                        rs.getInt("idDesempenhoTeste"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getFloat("velocidadeMedia"),
                        rs.getFloat("aceleracaoMedia"),
                        rs.getString("tempoPista"),
                        rs.getFloat("frenagem")
                );
                desempenhosTestes.add(desempenhoTeste);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return desempenhosTestes;
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
