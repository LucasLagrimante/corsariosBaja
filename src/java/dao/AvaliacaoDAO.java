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
import model.Avaliacao;

public class AvaliacaoDAO {

    private static AvaliacaoDAO instance = new AvaliacaoDAO();

    public static AvaliacaoDAO getInstance() {
        return instance;
    }

    private AvaliacaoDAO() {
    }

    //CLASSES PADRÃO
    public void salvar(Avaliacao avaliacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (avaliacao.getIdAvaliacao() != null) {
                em.merge(avaliacao);
            } else {
                em.persist(avaliacao);
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

    public Avaliacao getAvaliacao(int id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Avaliacao avaliacao = null;
        try {
            tx.begin();
            avaliacao = em.find(Avaliacao.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return avaliacao;
    }

    public void excluir(Avaliacao avaliacao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Avaliacao.class, avaliacao.getIdAvaliacao()));
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
    public List<Avaliacao> obterAvaliacoes() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Avaliacao> avaliacoes = null;
        try {
            tx.begin();
            TypedQuery<Avaliacao> query = em.createQuery("select c from Avaliacao c", Avaliacao.class);
            avaliacoes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return avaliacoes;
    }

}
