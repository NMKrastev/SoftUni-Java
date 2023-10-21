package bg.softuni.dictionaryApp.repository;

import bg.softuni.dictionaryApp.model.entity.Language;
import bg.softuni.dictionaryApp.model.entity.enums.LanguageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByName(LanguageEnum language);
}
