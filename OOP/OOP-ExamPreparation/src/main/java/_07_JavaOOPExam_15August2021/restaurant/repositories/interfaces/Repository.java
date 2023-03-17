package _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAllEntities();

    void add(T entity);

}
