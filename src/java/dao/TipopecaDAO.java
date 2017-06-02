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
import model.Tipopeca;

public class TipopecaDAO {

    private static TipopecaDAO instance = new TipopecaDAO();

    public static TipopecaDAO getInstance() {
        return instance;
    }

    private TipopecaDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Tipopeca tipopeca) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (tipopeca.getIdTipopeca() != null) {
                em.merge(tipopeca);
            } else {
                em.persist(tipopeca);
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

    public Tipopeca getTipopeca(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Tipopeca tipopeca = null;
        try {
            tx.begin();
            tipopeca = em.find(Tipopeca.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return tipopeca;
    }

    public void excluir(Tipopeca tipopeca) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Tipopeca.class, tipopeca.getIdTipopeca()));
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
    public List<Tipopeca> obterTipospeca() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Tipopeca> tipospeca = null;
        try {
            tx.begin();
            TypedQuery<Tipopeca> query = em.createQuery("select c from Tipopeca c", Tipopeca.class);
            tipospeca = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return tipospeca;
    }

}
