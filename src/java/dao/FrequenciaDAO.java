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
            String sql = "INSERT INTO frequencia (idFrequencia, data, estado,FK_integrante) VALUES (?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, frequencia.getIdFrequencia());
            comando.setString(2, frequencia.getData());
            comando.setString(3, frequencia.getEstado());
            comando.setInt(4, frequencia.getMatricula());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Frequencia> obterFrequencias() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Frequencia> frequencias = new ArrayList<Frequencia>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM frequencia");
            while (rs.next()) {
                Frequencia frequencia = new Frequencia(
                        rs.getInt("idFrequencia"),
                        rs.getString("data"),
                        rs.getString("estado"),
                        rs.getInt("FK_integrante")
                        
                );
                
                frequencias.add(frequencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return frequencias;
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
                    rs.getString("data"),
                    rs.getString("estado"),
                    rs.getInt("FK_integrante")
            );
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return frequencia;
    }
    
    public static void alterar(Frequencia frequencia) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "UPDATE frequencia SET data = ?, "
                    + "estado = ?, FK_integrante = ? "
                    + "WHERE IdFrequencia = ?";
            
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, frequencia.getData());
            comando.setString(2, frequencia.getEstado());
            comando.setInt(3, frequencia.getMatricula());
            comando.setInt(4, frequencia.getIdFrequencia());
            
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    
    public static void excluir(Frequencia frequencia) throws SQLException, ClassNotFoundException {
        try {
            Connection db = BD.getConexao();
            PreparedStatement st = db.prepareStatement("delete from frequencia where idFrequencia = ? ");
            st.setInt(1, frequencia.getIdFrequencia());
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            
        }
    }
}