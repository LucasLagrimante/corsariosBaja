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
import model.Automovel;

public class AutomovelDAO {

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

    public static void gravar(Automovel automovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO automovel (idAutomovel, cor, nome, dataTerminoProjeto, pesoCarro, pesoChassi, custoTotal) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, automovel.getIdAutomovel());
            comando.setString(2, automovel.getCor());
            comando.setString(3, automovel.getNome());
            comando.setString(4, automovel.getDataTerminoProjeto());
            comando.setFloat(5, automovel.getPesoCarro());
            comando.setFloat(6, automovel.getPesoChassi());
            comando.setFloat(7, automovel.getCustoTotal());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Automovel> obterAutomoveis() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Automovel> automoveis = new ArrayList<Automovel>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM automovel");
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

    public static Automovel obterAutomovel(int idAutomovel) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Automovel automovel = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM automovel where idAutomovel = " + idAutomovel);
            rs.first();
            automovel = new Automovel(
                    rs.getInt("idAutomovel"),
                    rs.getString("cor"),
                    rs.getString("nome"),
                    rs.getString("DataTerminoProjeto"),
                    rs.getFloat("PesoCarro"),
                    rs.getFloat("PesoChassi"),
                    rs.getFloat("custoTotal")
            //null
            );
            //automovel.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return automovel;
    }

    public static void alterar(Automovel automovel) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE automovel SET cor = ?, "
                    + "nome = ?, dataTerminoProjeto = ?, pesoCarro = ?, "
                    + "pesoChassi = ?, custoTotal = ? "
                    + "WHERE IdAutomovel = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, automovel.getCor());
            comando.setString(2, automovel.getNome());
            comando.setString(3, automovel.getDataTerminoProjeto());
            comando.setFloat(4, automovel.getPesoCarro());
            comando.setFloat(5, automovel.getPesoChassi());
            comando.setFloat(6, automovel.getCustoTotal());
            comando.setInt(7, automovel.getIdAutomovel());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void excluir(Automovel automovel) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from automovel where idAutomovel = ? ");
            st.setInt(1, automovel.getIdAutomovel());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {

        }
    }

}
