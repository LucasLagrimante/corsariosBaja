/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.DesempenhoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Desempenho;

@ManagedBean
@SessionScoped
public class DesempenhoBean extends CrudBean<Desempenho, DesempenhoDAO> {

    private DesempenhoDAO desempenhoDAO;

    @Override
    public DesempenhoDAO getDao() {
        if (desempenhoDAO == null) {
            desempenhoDAO = new DesempenhoDAO();
        }
        return desempenhoDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Desempenho criarNovaEntidade() {
        return new Desempenho();
    }

}
