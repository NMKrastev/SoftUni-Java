package _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces;

public interface TableRepository<T> extends Repository<T> {
    T byNumber(int number);
}
