package app.model.repository.implementation;

import app.configuration.HibernateConfiguration;
import app.model.Referee;
import app.model.TennisMatch;
import app.model.User;
import app.model.repository.RefereeRepositoryInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class RefereeRepository implements RefereeRepositoryInterface {
    @Override
    public Referee save(Referee entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnClientSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnClientSaved);
    }

    @Override
    public Referee update(Referee entity) {
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
    public List<Referee> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Native SQL - not preferred
        // Query query = session.createSQLQuery("select * from Client");

        TypedQuery<Referee> query = session.getNamedQuery("findAllReferees");
        List<Referee> referees = query.getResultList();

        transaction.commit();
        session.close();

        return referees;
    }

    @Override
    public Referee findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<Referee> query = session.getNamedQuery("findRefereeById");
        query.setParameter("id", id);

        Referee referee;
        try {
            referee = (Referee) query.getSingleResult();
        } catch (NoResultException e) {
            referee = null;
        }

        transaction.commit();
        session.close();

        return referee;
    }

    @Override
    public boolean delete(Referee entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }

   public Referee findRefereeByAssociatedUser(User user){
       SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
       Session session = sessionFactory.openSession();
       Transaction transaction = session.beginTransaction();

       TypedQuery<Referee> query = session.getNamedQuery("findRefereeByAssociatedUser");
       query.setParameter("user", user);

       Referee referee;
       try {
           referee = (Referee) query.getSingleResult();
       } catch (NoResultException e) {
           referee = null;
       }

       transaction.commit();
       session.close();

       return referee;
   }
    public List<TennisMatch>findAllTennisMatchesByReferee(Referee referee)
    {
        return referee.getTennisMatches();
    }

}
