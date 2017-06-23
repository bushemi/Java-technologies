package hibernate.dao;

import hibernate.entities.Dragon;
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
public class DragonDAO implements AbstractDAO<Dragon> {
    private Dragon dragon;
    private SessionFactory factory;
    private List<Dragon> list = new ArrayList<>();

    public DragonDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Dragon dragon) throws RuntimeException {
        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(dragon);
            transaction.commit();

        }
    }



    @Override
    public Dragon loadById(long id) throws RuntimeException {
        dragon =  null;
        try (Session session = factory.openSession()) {
            dragon = session.get(Dragon.class, id);
            return dragon;

        }
    }

    @Override
    public Dragon update(Dragon dragon) throws RuntimeException {
        dragon =  null;

        return dragon;
    }

    @Override
    public void delete(Dragon dragon) throws RuntimeException {

    }

    @Override
    public Collection<Dragon> getAll() throws RuntimeException {
        list = new ArrayList();
        try (Session session = factory.openSession()) {

            Transaction transaction = session.beginTransaction();
            String hql = "FROM Dragon";
            Query query = session.createQuery(hql);
            list = query.list();

            transaction.commit();
        }

        return list;

    }
}

