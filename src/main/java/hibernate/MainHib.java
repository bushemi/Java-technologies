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
        service.deleteDragon(d1);
        service.deleteElephant(el);
        list= (List) service.getAllDragons();
        list.forEach(System.out::println);
        service.updateElephant(el);
        service.updateDragon(d1);
        list= (List) service.getAllElephants();
        list.forEach(System.out::println);
//        System.out.println("one "+service.loadElephant(5));
        System.out.println("Animals was finished.");
        service.stop();
    }
}
