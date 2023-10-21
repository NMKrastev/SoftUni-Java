package bg.softuni.dictionaryApp.repository;

import bg.softuni.dictionaryApp.model.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    Optional<Word> findByTerm(String word);
}
