/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.FrequenciaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Frequencia;

@ManagedBean
@SessionScoped
public class FrequenciaBean extends CrudBean<Frequencia, FrequenciaDAO> {

    private FrequenciaDAO frequenciaDAO;

    @Override
    public FrequenciaDAO getDao() {
        if (frequenciaDAO == null) {
            frequenciaDAO = new FrequenciaDAO();
        }
        return frequenciaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Frequencia criarNovaEntidade() {
        return new Frequencia();
    }

}
