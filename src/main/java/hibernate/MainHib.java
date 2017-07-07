package hibernate;

import hibernate.entities.Dragon;
import hibernate.entities.Elephant;
import hibernate.services.DBService;

import java.util.List;

/**
 * Created by root on 20.06.17.
 */
public class MainHib {
    public static void main(String[] args) {
        System.out.println("Animals was started.");
        Dragon d1 = new Dragon(5,500,20);
        Elephant el = new Elephant(6,27,2);
        DBService service = DBService.getInstance();
        service.saveDragon(d1);
        service.saveElephant(el);
        List list= (List) service.getAllElephants();
        list.forEach(System.out::println);
        System.out.println(service.loadElephant(5));
        System.out.println("Animals was finished.");
        service.stop();
    }
}
