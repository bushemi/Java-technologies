package hibernate.dao.impl;

import hibernate.dao.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by root on 25.06.17.
 */
@SuppressWarnings("ALL")
abstract class AbstractAnimalDAO<T> implements AbstractDAO<T>{
    private T t;
    private SessionFactory factory;
    private List<T> list = new ArrayList<>();
    public AbstractAnimalDAO(SessionFactory factory) {
        this.factory = factory;
    }


    public void save(T t) throws RuntimeException{
        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();

        }
    }



    @Override
    public T loadById(long id) throws RuntimeException {
            t =  null;
        try (Session session = factory.openSession()) {
           t= sessionGetTById(session, id);
            return t;

        }
    }

    abstract T sessionGetTById(Session session, long id);



    @Override
    public T update(T t) throws RuntimeException {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String s = hqlUpdateString(t);
            Query query = session.createQuery(s);
            query.executeUpdate();
            transaction.commit();
        }


        return t;
    }

    @Override
    public void delete(T t) throws RuntimeException {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query q = session.createQuery(hqlDeleteQuery(t));
            q.executeUpdate();
            transaction.commit();
        }
    }
    abstract String hqlDeleteQuery(T t);
    abstract String hqlGetAll();
    abstract String hqlUpdateString(T t);

    public Collection<T> getAll() throws RuntimeException {
        list = new ArrayList();
        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            String hql = hqlGetAll();
            Query query = session.createQuery(hql);
            list = query.list();

            transaction.commit();
        }

        return list;

    }
}
