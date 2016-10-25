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
import model.Arquitetura;

public class ArquiteturaDAO {
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

    public static void gravar(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO avaliacao (idAvaliacao, frequencia, comparecimento, data, FK_integrante) VALUES (?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, avaliacao.getIdAvaliacao());
            comando.setInt(2, avaliacao.getFrequencia());
            comando.setString(3, avaliacao.getComparecimento());
            comando.setInt(4, avaliacao.getFK_integrante());
            comando.setString(5, avaliacao.getData());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    // problema
    public static List<Avaliacao> obterAvaliacoes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM avaliacao where idAvaliacao");
            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao(
                        rs.getInt("idAvaliacao"),
                        rs.getInt("frequencia"),
                        rs.getString("comparecimento"),
                        rs.getString("data"),
                        rs.getInt("FK_integrante")

                );
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return avaliacoes;
    }

    public static Avaliacao obterAvaliacao(int idAvaliacao) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Avaliacao avaliacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM avaliacao where idAvaliacao = " + idAvaliacao);
            rs.first();
            avaliacao = new Avaliacao(
                    rs.getInt("idAvaliacao"),
                        rs.getInt("frequencia"),
                        rs.getString("comparecimento"),
                        rs.getString("data"),
                        rs.getInt("FK_integrante")
            //null
            );
            //avaliacao.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return avaliacao;
    }

}