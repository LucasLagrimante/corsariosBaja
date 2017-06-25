/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CrudDAO;
import exception.ErroSistema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kaio
 * @param <E>
 * @param <D>
 */
public abstract class CrudBean<E, D extends CrudDAO> {

    private String estadoTela = "buscar";//Inserir, Editar, Buscar

    private E entidade;
    private List<E> entidades;

    public void novo() {
        entidade = criarNovaEntidade();
        mudarParaInseri();
    }

    /**
     *
     */
    public void salva() {
        getDao().salvar(entidade);
        entidade = criarNovaEntidade();
        adicionarMensagem("Salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        mudarParaBusca();
    }

    /**
     *
     * @param entidade
     */
    public void edita(E entidade) {
        this.entidade = entidade;
        mudarParaEdita();
    }

    /**
     *
     * @param entidade
     */
    public void exclui(E entidade) {
        getDao().excluir(entidade);
        entidades.remove(entidade);
        adicionarMensagem("Deletado com sucesso!", FacesMessage.SEVERITY_INFO);
    }

    public void busca() {
        if (isBusca() == false) {
            mudarParaBusca();
            return;
        }
        entidades = getDao().buscar();
        if (entidades == null || entidades.size() < 1) {
            adicionarMensagem("Não temos nada cadastrado!", FacesMessage.SEVERITY_WARN);
        }
    }

    public void adicionarMensagem(String mensagem, FacesMessage.Severity tipoErro) {
        FacesMessage fm = new FacesMessage(tipoErro, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }

    //getters e setters
    public E getEntidade() {
        return entidade;
    }

    public void setEntidade(E entidade) {
        this.entidade = entidade;
    }

    public List<E> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<E> entidades) {
        this.entidades = entidades;
    }

    //Responsvel por criar os métodos nas classes bean
    public abstract D getDao();

    public abstract E criarNovaEntidade();

    //Metodos para controle da tela
    public boolean isInseri() {
        return "inserir".equals(estadoTela);
    }

    public boolean isEdita() {
        return "editar".equals(estadoTela);
    }

    public boolean isBusca() {
        return "buscar".equals(estadoTela);
    }

    public void mudarParaInseri() {
        estadoTela = "inserir";
    }

    public void mudarParaEdita() {
        estadoTela = "editar";
    }

    public void mudarParaBusca() {
        estadoTela = "buscar";
    }

}
