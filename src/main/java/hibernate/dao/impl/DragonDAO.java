package hibernate.dao.impl;

import hibernate.dao.AbstractDAO;
import hibernate.entities.Dragon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 23.06.17.
 */
public class DragonDAO extends AbstractAnimalDAO<Dragon> implements AbstractDAO<Dragon> {
    private Dragon dragon;
    private SessionFactory factory;
    private List<Dragon> list = new ArrayList<>();

    public DragonDAO(SessionFactory factory) {
        super(factory);
    }

    @Override
    Dragon sessionGetTById(Session session, long id) {
        return session.get(Dragon.class, id);
    }

    @Override
    String hqlDeleteQuery() {
        return "delete Entity where id = X";
    }

    @Override
    String hqlGetAll() {
        return "FROM Dragon";
    }

    @Override
    String hqlUpdateString() {
        return "update EntityName set fieldP = 'newValue' "
                + "where id IN (75, 76)";
    }


}

