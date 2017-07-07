package hibernate.dao.impl;

import hibernate.dao.AbstractDAO;
import hibernate.entities.Elephant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23.06.17.
 */
public class ElephantDAO extends AbstractAnimalDAO<Elephant> implements AbstractDAO<Elephant>{
    private Elephant elephant;
    private List<Elephant> list = new ArrayList<>();
    private SessionFactory factory;

    public ElephantDAO(SessionFactory factory) {
        super(factory);

    }




    @Override
    Elephant sessionGetTById(Session session, long id) {
        return session.get(Elephant.class, id);
    }

    @Override
    String hqlDeleteQuery() {
        return "delete Entity where id = X";
    }

    @Override
    String hqlGetAll() {
        return "FROM Elephant";
    }

    @Override
    String hqlUpdateString() {
        return "update EntityName set fieldP = 'newValue' "
                + "where id IN (75, 76)";
    }


}


