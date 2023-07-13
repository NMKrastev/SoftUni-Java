package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.dtos.user.UserByPostCountDTO;
import softuni.exam.instagraphlite.models.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query("""
            SELECT NEW softuni.exam.instagraphlite.models.dtos.user.UserByPostCountDTO(u, COUNT(p.id))
            FROM User AS u 
            JOIN Post AS p ON p.user.id = u.id
            JOIN Picture AS pi ON pi.id = p.picture.id
            GROUP BY u.id
            ORDER BY COUNT(p.id) DESC, u.id
            """)
    List<UserByPostCountDTO> findUsersByCountOfPosts();

}
