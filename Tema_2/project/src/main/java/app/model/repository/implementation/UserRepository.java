package app.model.repository.implementation;

import app.configuration.HibernateConfiguration;
import app.model.Person;
import app.model.User;
import app.model.repository.UserRepositoryInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    @Override
    public User save(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer idOnClientSaved = (Integer) session.save(entity);

        transaction.commit();
        session.close();

        return findById(idOnClientSaved);
    }

    @Override
    public User update(User entity) {
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
    public List<User> findAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Native SQL - not preferred
        // Query query = session.createSQLQuery("select * from Client");

        TypedQuery<User> query = session.getNamedQuery("findAllUsers");
        List<User> users = query.getResultList();

        transaction.commit();
        session.close();

        return users;
    }

    @Override
    public User findById(Integer id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // HQL - Hibernate Query Language, but use named query instead to reuse them
        // Query query = session.createQuery("from Client where id=:id");
        // query.setParameter("id", id);

        TypedQuery<User> query = session.getNamedQuery("findUserById");
        query.setParameter("id", id);

        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public boolean delete(User entity) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Integer id = entity.getId();
        session.delete(entity);

        transaction.commit();
        session.close();

        return findById(id) == null;
    }

    @Override
    public User findUserByUsername(String username) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // TO DO
        // Same logic - extract it somehow
        TypedQuery<User> query = session.getNamedQuery("findUserByUsername");
        query.setParameter("userName", username);

        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public User findUserByAssociatedPerson(Person person)
    {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        TypedQuery<User> query = session.getNamedQuery("findUserByAssociatedPerson");
        query.setParameter("person", person);

        User user;
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }

        transaction.commit();
        session.close();

        return user;
    }
}
