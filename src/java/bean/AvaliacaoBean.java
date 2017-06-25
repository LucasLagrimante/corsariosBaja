/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AvaliacaoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Avaliacao;

@ManagedBean
@SessionScoped
public class AvaliacaoBean extends CrudBean<Avaliacao, AvaliacaoDAO> {

    private AvaliacaoDAO avaliacaoDAO;

    @Override
    public AvaliacaoDAO getDao() {
        if (avaliacaoDAO == null) {
            avaliacaoDAO = new AvaliacaoDAO();
        }
        return avaliacaoDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Avaliacao criarNovaEntidade() {
        return new Avaliacao();
    }

}
