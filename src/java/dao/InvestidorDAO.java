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
import model.Investidor;

public class InvestidorDAO {

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

    public static void gravar(Investidor investidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO investidor (IdInvestidor, valorDoado, FK_idPessoa) VALUES (?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, investidor.getIdInvestidor());
            comando.setFloat(2, investidor.getValorDoado());
            comando.setInt(3, investidor.getIdPessoa());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Investidor> obterInvestidores() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Investidor> investidores = new ArrayList<Investidor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM investidor");
            while (rs.next()) {
                Investidor investidor = new Investidor(
                        rs.getInt("IdInvestidor"),
                        rs.getFloat("valorDoado"),
                        rs.getInt("FK_idPessoa")
                );
                investidores.add(investidor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return investidores;
    }

    public static Investidor obterInvestidor(int IdInvestidor) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Investidor investidor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM investidor where IdInvestidor = " + IdInvestidor);
            rs.first();
            investidor = new Investidor(
                    rs.getInt("IdInvestidor"),
                    rs.getFloat("valorDoado"),
                    rs.getInt("FK_idPessoa")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return investidor;
    }

    public static void alterar(Investidor investidor) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE investidor SET valorDoado = ?, "
                    + "FK_idPessoa = ? "
                    + "WHERE IdInvestidor = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setFloat(1, investidor.getValorDoado());
            comando.setInt(2, investidor.getIdPessoa());
            comando.setInt(3, investidor.getIdInvestidor());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
   public static void excluir(Investidor investidor) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from investidor where IdInvestidor = ?");
            st.setInt(1, investidor.getIdInvestidor());
            st.execute();
            st.close();
        } catch (SQLException ex) {
            
        }
    }

}
