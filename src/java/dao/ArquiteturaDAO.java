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
import model.Arquitetura;

public class ArquiteturaDAO {

    private static ArquiteturaDAO instance = new ArquiteturaDAO();

    public static ArquiteturaDAO getInstance() {
        return instance;
    }

    private ArquiteturaDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Arquitetura arquitetura) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (arquitetura.getIdArquitetura() != null) {
                em.merge(arquitetura);
            } else {
                em.persist(arquitetura);
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

    public Arquitetura getArquitetura(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Arquitetura arquitetura = null;
        try {
            tx.begin();
            arquitetura = em.find(Arquitetura.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return arquitetura;
    }

    public void excluir(Arquitetura arquitetura) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Arquitetura.class, arquitetura.getIdArquitetura()));
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
    public List<Arquitetura> obterArquiteturas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Arquitetura> arquiteturas = null;
        try {
            tx.begin();
            TypedQuery<Arquitetura> query = em.createQuery("select c from Arquitetura c", Arquitetura.class);
            arquiteturas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return arquiteturas;
    }

}
