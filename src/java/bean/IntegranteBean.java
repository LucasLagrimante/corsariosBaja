/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.IntegranteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Integrante;

@ManagedBean
@SessionScoped
public class IntegranteBean extends CrudBean<Integrante, IntegranteDAO> {

    private IntegranteDAO integranteDAO;

    @Override
    public IntegranteDAO getDao() {
        if (integranteDAO == null) {
            integranteDAO = new IntegranteDAO();
        }
        return integranteDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Integrante criarNovaEntidade() {
        return new Integrante();
    }

}
