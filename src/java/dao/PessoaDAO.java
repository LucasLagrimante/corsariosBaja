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
import model.Pessoa;

public class PessoaDAO {

    public static List<Pessoa> obterPessoas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pessoa");
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getInt("idPessoa"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("logradouro"),
                        rs.getString("cep"),
                        rs.getString("bairro"),
                        rs.getString("uf"),
                        rs.getString("numero"),
                        rs.getString("telefone")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoas;
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
    public static void gravar(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "INSERT INTO pessoa (idPessoa,nome,cpf, logradouro,cep,bairro,uf,numero,telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, pessoa.getIdPessoa());
            comando.setString(2, pessoa.getNome());
            comando.setString(3, pessoa.getCpf());
            comando.setString(4, pessoa.getLogradouro());
            comando.setString(5, pessoa.getCep());
            comando.setString(6, pessoa.getBairro());
            comando.setString(7, pessoa.getUf());
            comando.setString(8, pessoa.getNumero());
            comando.setString(9, pessoa.getTelefone());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public static Pessoa obterPessoa(int idPessoa) throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Pessoa pessoa = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("SELECT * FROM pessoa where idPessoa = " + idPessoa);
            rs.first();
            pessoa = new Pessoa(
                        rs.getInt("idPessoa"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("logradouro"),
                        rs.getString("cep"),
                        rs.getString("bairro"),
                        rs.getString("uf"),
                        rs.getString("numero"),
                        rs.getString("telefone")
            //null
            );
            //automovel.setCodigoPessoa(rs.getString("pessoa"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return pessoa;
    }
}
