/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DesignDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Design;

@ManagedBean
@SessionScoped
public class DesignBean extends CrudBean<Design, DesignDAO> {

    private DesignDAO designDAO;

    @Override
    public DesignDAO getDao() {
        if (designDAO == null) {
            designDAO = new DesignDAO();
        }
        return designDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Design criarNovaEntidade() {
        return new Design();
    }

}
