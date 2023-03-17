package _07_JavaOOPExam_15August2021.restaurant.repositories.interfaces;

public interface BeverageRepository<T> extends Repository<T> {
    T beverageByName(String drinkName,String drinkBrand);
}
