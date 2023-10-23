package bg.softuni.sa01_webapiandrestcontrollers.repository;

import bg.softuni.sa01_webapiandrestcontrollers.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
