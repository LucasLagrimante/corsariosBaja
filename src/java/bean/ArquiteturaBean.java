/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ArquiteturaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Arquitetura;

@ManagedBean
@SessionScoped
public class ArquiteturaBean extends CrudBean<Arquitetura, ArquiteturaDAO> {

    private ArquiteturaDAO arquiteturaDAO;

    @Override
    public ArquiteturaDAO getDao() {
        if (arquiteturaDAO == null) {
            arquiteturaDAO = new ArquiteturaDAO();
        }
        return arquiteturaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Arquitetura criarNovaEntidade() {
        return new Arquitetura();
    }

}
