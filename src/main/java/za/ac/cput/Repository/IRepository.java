package za.ac.cput.Repository;
/**
 * @author Zahrah Vermaak 221406395
 */

import java.util.List;


public interface IRepository <T, ID>  {

        T create(T entity);
        T read(ID id);
        T update(T entity);
        boolean delete(ID id);
        List<T> getAll();

}
