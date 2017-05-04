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
import model.Desempenho;
import model.TipoPista;

public class DesempenhoDAO {

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

    public static void gravar(Desempenho desempenho) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO desempenho (idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem, FK_automovel, FK_tipopista, FK_motorista) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, desempenho.getIdDesempenho());
            comando.setString(2, desempenho.getNome());
            comando.setString(3, desempenho.getData());
            comando.setString(4, desempenho.getHora());
            comando.setFloat(5, desempenho.getVelocidadeMedia());
            comando.setFloat(6, desempenho.getAceleracaoMedia());
            comando.setString(7, desempenho.getTempoPista());
            comando.setFloat(8, desempenho.getFrenagem());
            comando.setInt(9, desempenho.getIdAutomovel());
            comando.setInt(10, desempenho.getIdTipoPista());
            comando.setInt(11, desempenho.getMatricula());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Desempenho> obterDesempenhos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Desempenho> desempenhos = new ArrayList<Desempenho>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM desempenho");
            while (rs.next()) {
                Desempenho desempenho = new Desempenho(
                        rs.getInt("idDesempenho"),
                        rs.getString("nome"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getFloat("velocidadeMedia"),
                        rs.getFloat("aceleracaoMedia"),
                        rs.getString("tempoPista"),
                        rs.getFloat("frenagem"),
                        rs.getInt("FK_automovel"),
                        rs.getInt("FK_tipopista"),
                        rs.getInt("FK_motorista")
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

    public static Desempenho obterDesempenho(int idDesempenho) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Desempenho desempenho = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM desempenho where idDesempenho = " + idDesempenho);
            rs.first();
            desempenho = new Desempenho(
                    rs.getInt("idDesempenho"),
                    rs.getString("nome"),
                    rs.getString("data"),
                    rs.getString("hora"),
                    rs.getFloat("velocidadeMedia"),
                    rs.getFloat("aceleracaoMedia"),
                    rs.getString("tempoPista"),
                    rs.getFloat("frenagem"),
                    rs.getInt("FK_automovel"),
                    rs.getInt("FK_tipopista"),
                    rs.getInt("FK_motorista")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return desempenho;
    }

    public static void alterar(Desempenho desempenho) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE desempenho SET nome = ?, "
                    + "data = ?, hora = ?, velocidadeMedia = ?, "
                    + "aceleracaoMedia = ?, tempoPista = ?, "
                    + "frenagem = ?, FK_automovel = ?, FK_tipopista = ?, FK_motorista = ? "
                    + "WHERE IdDesempenho = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, desempenho.getNome());
            comando.setString(2, desempenho.getData());
            comando.setString(3, desempenho.getHora());
            comando.setFloat(4, desempenho.getVelocidadeMedia());
            comando.setFloat(5, desempenho.getAceleracaoMedia());
            comando.setString(6, desempenho.getTempoPista());
            comando.setFloat(7, desempenho.getFrenagem());
            comando.setInt(8, desempenho.getIdAutomovel());
            comando.setInt(9, desempenho.getIdTipoPista());
            comando.setInt(10, desempenho.getMatricula());
            comando.setInt(11, desempenho.getIdDesempenho());

            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Desempenho desempenho) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from desempenho where idDesempenho = ? ");
            st.setInt(1, desempenho.getIdDesempenho());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {

        }
    }

    public static List<String> obterPistas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<String> pistas = new ArrayList<String>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT DISTINCT nome FROM tipopista");
            while (rs.next()) {
                pistas.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pistas;
    }

}
