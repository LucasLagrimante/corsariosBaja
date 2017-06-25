/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PecaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Peca;

@ManagedBean
@SessionScoped
public class PecaBean extends CrudBean<Peca, PecaDAO> {

    private PecaDAO pecaDAO;

    @Override
    public PecaDAO getDao() {
        if (pecaDAO == null) {
            pecaDAO = new PecaDAO();
        }
        return pecaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Peca criarNovaEntidade() {
        return new Peca();
    }

}
