package _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces;

public interface HealthFoodRepository<T> extends Repository<T> {
    T foodByName(String name);
}
