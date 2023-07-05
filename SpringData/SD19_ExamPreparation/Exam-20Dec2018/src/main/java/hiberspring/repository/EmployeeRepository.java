package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM employees AS e " +
            "JOIN branches AS b ON e.branch_id = b.id " +
            "JOIN employees_cards ec ON e.card_id = ec.id " +
            "WHERE b.id IN (SELECT p.branch_id FROM products AS p) " +
            "ORDER BY CONCAT_WS(' ', e.first_name, e.last_name), CHAR_LENGTH(e.position) DESC;")
    List<Employee> findAllEmployeesOnBranchWithAtLeastOneProduct();
}
