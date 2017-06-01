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
import model.Investidor;

public class InvestidorDAO {

    private static InvestidorDAO instance = new InvestidorDAO();

    public static InvestidorDAO getInstance() {
        return instance;
    }

    private InvestidorDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Investidor integrante) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (integrante.getIdInvestidor() != null) {
                em.merge(integrante);
            } else {
                em.persist(integrante);
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

    public static Investidor getInvestidor(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Investidor integrante = null;
        try {
            tx.begin();
            integrante = em.find(Investidor.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return integrante;
    }

    public void excluir(Investidor integrante) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Investidor.class, integrante.getIdInvestidor()));
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
    public static List<Investidor> obterInvestidores() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Investidor> investidores = null;
        try {
            tx.begin();
            TypedQuery<Investidor> query = em.createQuery("select c from Investidor c", Investidor.class);
            investidores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return investidores;
    }

    public static List<Investidor> obterPessoas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Investidor> investidores = null;
        try {
            tx.begin();
            TypedQuery<Investidor> query = em.createQuery("select c from Investidor c", Investidor.class);
            investidores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return investidores;
    }

}
