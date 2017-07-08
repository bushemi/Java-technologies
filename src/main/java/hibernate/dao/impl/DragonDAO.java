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
    String hqlDeleteQuery(Dragon dragon) {
        return "delete Dragon where id < 5";
    }

    @Override
    String hqlGetAll() {
        return "FROM Dragon";
    }

    @Override
    String hqlUpdateString(Dragon dragon) {
        StringBuilder sb = new StringBuilder();
        sb.append("update Dragon set ")
                .append("maxFlyingTime = '")
                .append(dragon.getMaxFlyingTime()*10)
                .append("' where id > 5");

        return sb.toString();
    }


}

