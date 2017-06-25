/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Lucas
 * @param <E>
 */
public interface CrudDAO<E> {

    /**
     *
     * @param entidade
     */
    public void salvar(E entidade);

    /**
     *
     * @param entidade
     */
    public void excluir(E entidade);

    /**
     *
     * @return
     */
    public List<E> buscar();
}
