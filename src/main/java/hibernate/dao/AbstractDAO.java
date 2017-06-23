package hibernate.dao;

import java.util.Collection;

/**
 * Created by root on 23.06.17.
 */
public interface AbstractDAO<T> {
    //CRUD create read update delete
   public void save(T t) throws RuntimeException;
   public T loadById(long id) throws RuntimeException;
   public T update(T t) throws RuntimeException;
   public void delete(T t) throws RuntimeException;
   public Collection<T> getAll() throws RuntimeException;
}
