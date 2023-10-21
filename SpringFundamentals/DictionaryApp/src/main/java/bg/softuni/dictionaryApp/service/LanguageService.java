package bg.softuni.dictionaryApp.service;

import bg.softuni.dictionaryApp.model.dto.WordDTO;
import bg.softuni.dictionaryApp.model.entity.Language;
import bg.softuni.dictionaryApp.model.entity.Word;
import bg.softuni.dictionaryApp.model.entity.enums.LanguageEnum;
import bg.softuni.dictionaryApp.model.mapper.WordMapper;
import bg.softuni.dictionaryApp.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final WordMapper wordMapper;

    public LanguageService(LanguageRepository languageRepository, WordMapper wordMapper) {

        this.languageRepository = languageRepository;
        this.wordMapper = wordMapper;
    }

    public Language findLanguage(LanguageEnum languageByName) {

        final LanguageEnum language = LanguageEnum.valueOf(languageByName.name());

        return this.languageRepository
                .findByName(language);
    }

    public List<WordDTO> findAllWordsByLanguage(String language) {

        return this.languageRepository
                .findByName(LanguageEnum.valueOf(language))
                .getWords()
                .stream()
                .sorted(Comparator.comparing(Word::getInputDate))
                .map(this.wordMapper::wordToWordDto)
                .toList();
    }
}
