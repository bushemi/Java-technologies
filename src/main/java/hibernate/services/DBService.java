package hibernate.services;

import hibernate.dao.DragonDAO;
import hibernate.dao.ElephantDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 04.06.2017.
 */
public class DBService {
    private SessionFactory factory;
    private static DBService instance;
    private List list = new ArrayList();
    private ElephantDAO elDAO;
    private DragonDAO  draDAO;


    private DBService() {
    factory = new Configuration()
            .configure()
            .buildSessionFactory();
    }

    public static DBService getInstance() {
        if (instance==null) {
            instance = new DBService();
        }
        return instance;
    }
//CRUD create read update delete

}
