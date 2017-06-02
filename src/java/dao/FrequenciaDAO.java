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
import model.Frequencia;

public class FrequenciaDAO {

    private static FrequenciaDAO instance = new FrequenciaDAO();

    public static FrequenciaDAO getInstance() {
        return instance;
    }

    private FrequenciaDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Frequencia frequencia) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (frequencia.getIdFrequencia() != null) {
                em.merge(frequencia);
            } else {
                em.persist(frequencia);
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

    public Frequencia getFrequencia(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Frequencia frequencia = null;
        try {
            tx.begin();
            frequencia = em.find(Frequencia.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return frequencia;
    }

    public void excluir(Frequencia frequencia) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Frequencia.class, frequencia.getIdFrequencia()));
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
    public List<Frequencia> obterFrequencias() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Frequencia> frequencias = null;
        try {
            tx.begin();
            TypedQuery<Frequencia> query = em.createQuery("select c from Frequencia c", Frequencia.class);
            frequencias = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return frequencias;
    }

    public List<Frequencia> obterEstados() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Frequencia> frequencias = null;
        try {
            tx.begin();
            TypedQuery<Frequencia> query = em.createQuery("select c from Frequencia c", Frequencia.class);
            frequencias = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return frequencias;
    }

}
