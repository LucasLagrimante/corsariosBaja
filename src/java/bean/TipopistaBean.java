/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TipopistaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Tipopista;

@ManagedBean
@SessionScoped
public class TipopistaBean extends CrudBean<Tipopista, TipopistaDAO> {

    private TipopistaDAO tipopistaDAO;

    @Override
    public TipopistaDAO getDao() {
        if (tipopistaDAO == null) {
            tipopistaDAO = new TipopistaDAO();
        }
        return tipopistaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Tipopista criarNovaEntidade() {
        return new Tipopista();
    }

}
