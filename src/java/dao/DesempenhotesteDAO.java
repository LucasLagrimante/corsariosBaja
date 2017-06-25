/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Desempenhoteste;

public class DesempenhotesteDAO implements CrudDAO<Desempenhoteste> {

    private static DesempenhotesteDAO instance = new DesempenhotesteDAO();

    public static DesempenhotesteDAO getInstance() {
        return instance;
    }

    public DesempenhotesteDAO() {
    }

    @Override
    public void salvar(Desempenhoteste desempenhoTeste) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(desempenhoTeste);
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

    public void alterar(Desempenhoteste desempenhoTeste) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(desempenhoTeste);
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

    public Desempenhoteste getDesempenhoteste(Integer id) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Desempenhoteste desempenhoTeste = null;
        try {
            tx.begin();
            desempenhoTeste = em.find(Desempenhoteste.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return desempenhoTeste;
    }

    @Override
    public void excluir(Desempenhoteste desempenhoTeste) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Desempenhoteste.class, desempenhoTeste.getIdDesempenhoteste()));
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

    @Override
    public List<Desempenhoteste> buscar() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Desempenhoteste> desempenhosTeste = null;
        try {
            tx.begin();
            TypedQuery<Desempenhoteste> query = em.createQuery("select d from Desempenhoteste d", Desempenhoteste.class);
            desempenhosTeste = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return desempenhosTeste;
    }

}
