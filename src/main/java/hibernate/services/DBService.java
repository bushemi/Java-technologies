package hibernate.services;

import hibernate.dao.AbstractDAO;
import hibernate.dao.impl.DragonDAO;
import hibernate.dao.impl.ElephantDAO;
import hibernate.entities.Dragon;
import hibernate.entities.Elephant;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Игорь on 04.06.2017.
 */
public class DBService {
    private SessionFactory factory;
    private static DBService instance;
    private List list = new ArrayList();
    private AbstractDAO<Elephant>  elDAO;
    private AbstractDAO<Dragon>  draDAO;


    private DBService() {
    factory = new Configuration()
            .configure()
            .buildSessionFactory();
    elDAO=new ElephantDAO(factory);
    draDAO = new DragonDAO(factory);
    }

    public static DBService getInstance() {
        if (instance==null) {
            instance = new DBService();
        }
        return instance;
    }
//CRUD create read update delete
    public void saveElephant(Elephant elephant){
        elDAO.save(elephant);
    }
    public Elephant loadElephant(long id){
       return elDAO.loadById(id);
    }
    public void deleteElephant(Elephant elephant){
        elDAO.delete(elephant);
    }
    public void updateElephant(Elephant elephant){
        elDAO.update(elephant);
    }
    public Collection<Elephant> getAllElephants() {return elDAO.getAll();}

    public void saveDragon(Dragon dragon){draDAO.save(dragon);}
    public Dragon loadDragon(long id){
      return  draDAO.loadById(id);
    }
    public void deleteDragon(Dragon dragon){
        draDAO.delete(dragon);
    }
    public void updateDragon(Dragon dragon){
        draDAO.update(dragon);
    }
    public Collection<Dragon> getAllDragons() {return draDAO.getAll();}



    public void stop(){
        factory.close();
    }
}
