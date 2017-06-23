package hibernate.dao;

import hibernate.entities.Elephant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by root on 23.06.17.
 */
public class ElephantDAO implements AbstractDAO<Elephant> {
    private Elephant elephant;
    private List<Elephant> list = new ArrayList<>();
    private SessionFactory factory;

    public ElephantDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Elephant elephant) throws RuntimeException {

        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(elephant);
            transaction.commit();

        }
    }


    @Override
    public Elephant loadById(long id) throws RuntimeException {
        elephant = null;
        try (Session session = factory.openSession()) {
            elephant = session.get(Elephant.class, id);
            return elephant;

        }
    }

    @Override
    public Elephant update(Elephant elephant) throws RuntimeException {
        elephant = null;

        return elephant;
    }

    @Override
    public void delete(Elephant elephant) throws RuntimeException {

    }

    @Override
    public Collection<Elephant> getAll() throws RuntimeException {

        list = new ArrayList();
        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            String hql = "FROM Elephant";
            Query query = session.createQuery(hql);
            list = query.list();

            transaction.commit();
        }

        return list;

    }
}


