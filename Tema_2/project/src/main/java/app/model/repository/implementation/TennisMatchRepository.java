package app.model.repository.implementation;

import app.configuration.HibernateConfiguration;
import app.model.TennisMatch;
import app.model.repository.TennisMatchRepositoryInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class TennisMatchRepository implements TennisMatchRepositoryInterface {
    @Override
    public TennisMatch save(TennisMatch entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnClientSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnClientSaved);
    }

    @Override
    public TennisMatch update(TennisMatch entity) {
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
    public List<TennisMatch> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Native SQL - not preferred
        // Query query = session.createSQLQuery("select * from Client");

        TypedQuery<TennisMatch> query = session.getNamedQuery("findAllTennisMatches");
        List<TennisMatch> tennisMatches = query.getResultList();

        transaction.commit();
        session.close();

        return tennisMatches;
    }

    @Override
    public TennisMatch findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<TennisMatch> query = session.getNamedQuery("findTennisMatchById");
        query.setParameter("id", id);

        TennisMatch tennisMatch;
        try {
            tennisMatch = (TennisMatch) query.getSingleResult();
        } catch (NoResultException e) {
            tennisMatch = null;
        }

        transaction.commit();
        session.close();

        return tennisMatch;
    }

    @Override
    public List<TennisMatch> findAllByRefereeId(Integer refereeId) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<TennisMatch> query = session.getNamedQuery("findAllTennisMatchesByRefereeId");
        query.setParameter("id", refereeId);

        List<TennisMatch> tennisMatches = query.getResultList();

        transaction.commit();
        session.close();
        return tennisMatches;
    }

    @Override
    public List<TennisMatch> findAllByTennisPlayerId(Integer tennisPlayerId) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<TennisMatch> query = session.getNamedQuery("findAllTennisMatchesByTennisPlayerId");
        query.setParameter("id", tennisPlayerId);

        List<TennisMatch> tennisMatches = query.getResultList();

        transaction.commit();
        session.close();
        return tennisMatches;
    }

    @Override
    public boolean delete(TennisMatch entity) {
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
