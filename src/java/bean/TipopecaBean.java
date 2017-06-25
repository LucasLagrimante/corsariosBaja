/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TipopecaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Tipopeca;

@ManagedBean
@SessionScoped
public class TipopecaBean extends CrudBean<Tipopeca, TipopecaDAO> {

    private TipopecaDAO tipopecaDAO;

    @Override
    public TipopecaDAO getDao() {
        if (tipopecaDAO == null) {
            tipopecaDAO = new TipopecaDAO();
        }
        return tipopecaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Tipopeca criarNovaEntidade() {
        return new Tipopeca();
    }

}
