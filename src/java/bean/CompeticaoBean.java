/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.CompeticaoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Competicao;

@ManagedBean
@SessionScoped
public class CompeticaoBean extends CrudBean<Competicao, CompeticaoDAO> {

    private CompeticaoDAO competicaoDAO;

    @Override
    public CompeticaoDAO getDao() {
        if (competicaoDAO == null) {
            competicaoDAO = new CompeticaoDAO();
        }
        return competicaoDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Competicao criarNovaEntidade() {
        return new Competicao();
    }

}
