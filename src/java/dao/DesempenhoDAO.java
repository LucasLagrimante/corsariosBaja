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
import model.Desempenho;

public class DesempenhoDAO {

    private static DesempenhoDAO instance = new DesempenhoDAO();

    public static DesempenhoDAO getInstance() {
        return instance;
    }

    private DesempenhoDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Desempenho desempenho) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (desempenho.getIdDesempenho() != null) {
                em.merge(desempenho);
            } else {
                em.persist(desempenho);
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

    public Desempenho getDesempenho(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Desempenho desempenho = null;
        try {
            tx.begin();
            desempenho = em.find(Desempenho.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return desempenho;
    }

    public void excluir(Desempenho desempenho) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Desempenho.class, desempenho.getIdDesempenho()));
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
    public List<Desempenho> obterDesempenhos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Desempenho> desempenhos = null;
        try {
            tx.begin();
            TypedQuery<Desempenho> query = em.createQuery("select c from Desempenho c", Desempenho.class);
            desempenhos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return desempenhos;
    }

    public List<Desempenho> obterPistas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Desempenho> desempenhos = null;
        try {
            tx.begin();
            TypedQuery<Desempenho> query = em.createQuery("select c from Desempenho c", Desempenho.class);
            desempenhos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return desempenhos;
    }

}
