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
import model.Frequencia;

public class FrequenciaDAO {

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

    public static void gravar(Frequencia frequencia) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO frequencia (idFrequencia, FK_integrante, data, estado) VALUES (?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, frequencia.getIdFrequencia());
            comando.setInt(2, frequencia.getFK_integrante());
            comando.setString(3, frequencia.getData());
            comando.setString(4, frequencia.getEstado());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    // problema
    public static List<Frequencia> obterFrequencias() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Frequencia> automoveis = new ArrayList<Frequencia>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM frequencia where idFrequencia");
            while (rs.next()) {
                Frequencia frequencia = new Frequencia(
                        rs.getInt("idFrequencia"),
                        rs.getInt("FK_integrante"),
                        rs.getString("data"),
                        rs.getString("estado")
                );
                automoveis.add(frequencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return automoveis;
    }

    public static Frequencia obterFrequencia(int idFrequencia) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Frequencia frequencia = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM frequencia where idFrequencia = " + idFrequencia);
            rs.first();
            frequencia = new Frequencia(
                        rs.getInt("idFrequencia"),
                        rs.getInt("FK_integrante"),
                        rs.getString("data"),
                        rs.getString("estado")
            );
            frequencia.setFK_integrante(rs.getInt("FK_integrante"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return frequencia;
    }


}
