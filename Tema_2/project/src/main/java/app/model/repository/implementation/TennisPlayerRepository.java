package app.model.repository.implementation;

import app.configuration.HibernateConfiguration;
import app.model.TennisPlayer;
import app.model.repository.TennisPlayerRepositoryInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
public class TennisPlayerRepository implements TennisPlayerRepositoryInterface {
    @Override
    public TennisPlayer save(TennisPlayer tennisPlayer) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnClientSaved = (Integer) session.save(tennisPlayer);

        transaction.commit();
        session.close();

        return findById(idOnClientSaved);
    }

    @Override
    public TennisPlayer update(TennisPlayer entity) {
        // TO DO
        // Same logic - extract it somehow
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.saveOrUpdate(entity);

        transaction.commit();
        session.close();

        return findById(id);
    }

    @Override
    public List<TennisPlayer> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Native SQL - not preferred
        // Query query = session.createSQLQuery("select * from Client");

        TypedQuery<TennisPlayer> query = session.getNamedQuery("findAllTennisPlayers");
        List<TennisPlayer> tennisPlayers = query.getResultList();

        transaction.commit();
        session.close();

        return tennisPlayers;
    }

    @Override
    public TennisPlayer findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<TennisPlayer> query = session.getNamedQuery("findTennisPlayerById");
        query.setParameter("id", id);

        TennisPlayer tennisPlayer;
        try {
            tennisPlayer = (TennisPlayer) query.getSingleResult();
        } catch (NoResultException e) {
            tennisPlayer = null;
        }

        transaction.commit();
        session.close();

        return tennisPlayer;
    }

    @Override
    public boolean delete(TennisPlayer entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }

}
