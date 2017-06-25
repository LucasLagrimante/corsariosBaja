/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DesempenhotesteDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Desempenhoteste;

@ManagedBean
@SessionScoped
public class DesempenhotesteBean extends CrudBean<Desempenhoteste, DesempenhotesteDAO> {

    private DesempenhotesteDAO desempenhotesteDAO;

    @Override
    public DesempenhotesteDAO getDao() {
        if (desempenhotesteDAO == null) {
            desempenhotesteDAO = new DesempenhotesteDAO();
        }
        return desempenhotesteDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Desempenhoteste criarNovaEntidade() {
        return new Desempenhoteste();
    }

}
