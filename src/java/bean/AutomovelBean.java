/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AutomovelDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Automovel;

@ManagedBean
@SessionScoped
public class AutomovelBean extends CrudBean<Automovel, AutomovelDAO> {

    private AutomovelDAO automovelDAO;

    @Override
    public AutomovelDAO getDao() {
        if (automovelDAO == null) {
            automovelDAO = new AutomovelDAO();
        }
        return automovelDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Automovel criarNovaEntidade() {
        return new Automovel();
    }

}
