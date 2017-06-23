package hibernate.dao;

import java.util.Collection;

/**
 * Created by root on 23.06.17.
 */
public interface AbstractDAO<T> {
    //CRUD create read update delete
   public void save() throws RuntimeException;
   public T load() throws RuntimeException;
   public T update() throws RuntimeException;
   public void delete() throws RuntimeException;
   public Collection<T> getAll() throws RuntimeException;
}
