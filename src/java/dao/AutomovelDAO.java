/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Automovel;

public class AutomovelDAO {

    private static AutomovelDAO instance = new AutomovelDAO();

    public static AutomovelDAO getInstance() {
        return instance;
    }

    private AutomovelDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Automovel automovel) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (automovel.getIdAutomovel() != null) {
                em.merge(automovel);
            } else {
                em.persist(automovel);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    public Automovel getAutomovel(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Automovel automovel = null;
        try {
            tx.begin();
            automovel = em.find(Automovel.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return automovel;
    }

    public void excluir(Automovel automovel) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Automovel.class, automovel.getIdAutomovel()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }

    // OBTER PARA OS SELECTS
    public List<Automovel> obterAutomoveis() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Automovel> automoveis = null;
        try {
            tx.begin();
            TypedQuery<Automovel> query = em.createQuery("select c from Automovel c", Automovel.class);
            automoveis = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return automoveis;
    }

    public List<Automovel> obterCores() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Automovel> automoveis = null;
        try {
            tx.begin();
            TypedQuery<Automovel> query = em.createQuery("select c from Automovel c", Automovel.class);
            automoveis = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return automoveis;
    }

    public List<Automovel> obterPesos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Automovel> automoveis = null;
        try {
            tx.begin();
            TypedQuery<Automovel> query = em.createQuery("select c from Automovel c", Automovel.class);
            automoveis = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return automoveis;
    }
}
