/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.PessoaDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaBean extends CrudBean<Pessoa, PessoaDAO> {

    private PessoaDAO pessoaDAO;

    @Override
    public PessoaDAO getDao() {
        if (pessoaDAO == null) {
            pessoaDAO = new PessoaDAO();
        }
        return pessoaDAO;
    }

    /**
     *
     * @return
     */
    @Override
    public Pessoa criarNovaEntidade() {
        return new Pessoa();
    }

}
