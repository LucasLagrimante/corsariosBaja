package model;

import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

public class Pessoa {

    private int idPessoa;
    private String nome,cpf,logradouro,cep, bairro, uf, numero, telefone;

    public Pessoa(int idPessoa, String nome, String cpf, String logradouro, String cep, String bairro, String uf, String numero, String telefone) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.uf = uf;
        this.numero = numero;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setId(int id) {
        this.idPessoa = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String geCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public static List<Pessoa> obterPessoas() throws ClassNotFoundException, SQLException{
        return PessoaDAO.obterPessoas();
    }
     public void gravar() throws SQLException, ClassNotFoundException {
        PessoaDAO.gravar(this);
    }

    public static Pessoa obterPessoa(int idPessoa) throws ClassNotFoundException {
        return PessoaDAO.obterPessoa(idPessoa);
    }

}
