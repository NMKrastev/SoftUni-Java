package _03_JavaOOPExam_12December2020.bakery.repositories.interfaces;

public interface FoodRepository<T> extends Repository<T> {
    T getByName(String name);
}
