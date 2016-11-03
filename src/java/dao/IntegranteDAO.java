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
import model.Integrante;

public class IntegranteDAO {

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

    public static void gravar(Integrante integrante) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO integrante (matricula, cargaHorariaDisponivel, FK_integrante) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, integrante.getMatricula());
            comando.setString(2, integrante.getCargaHorariaDisponivel());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Integrante> obterIntegrantes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Integrante> integrantes = new ArrayList<Integrante>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM integrante");
            while (rs.next()) {
                Integrante integrante = new Integrante(
                        rs.getInt("matricula"),
                        rs.getString("cargaHorariaDisponivel"),
                        null
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

    public static Integrante obterIntegrante(int matricula) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Integrante integrante = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM integrante where matricula = " + matricula);
            rs.first();
            integrante = new Integrante(
                    rs.getInt("matricula"),
                    rs.getString("cargaHorariaDisponivel"),
                    null
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return integrante;
    }
    
    public void excluir(Integrante Integrante) {
        try {
            Connection db = Conexao.getConnection();
            PreparedStatement st = db.prepareStatement("delete from integrante where matricula = ?");
            st.setInt(1, Integrante.getMatricula());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {

        }
    }

}
