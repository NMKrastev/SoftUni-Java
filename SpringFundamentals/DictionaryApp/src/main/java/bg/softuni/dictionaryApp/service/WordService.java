package bg.softuni.dictionaryApp.service;

import bg.softuni.dictionaryApp.model.dto.AddWordDTO;
import bg.softuni.dictionaryApp.model.entity.Language;
import bg.softuni.dictionaryApp.model.entity.User;
import bg.softuni.dictionaryApp.model.entity.Word;
import bg.softuni.dictionaryApp.model.mapper.WordMapper;
import bg.softuni.dictionaryApp.repository.WordRepository;
import bg.softuni.dictionaryApp.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WordService {

    private final WordRepository wordRepository;
    private final LanguageService languageService;
    private final UserService userService;
    private final WordMapper wordMapper;
    private final CurrentUser currentUser;

    public WordService(WordRepository wordRepository, LanguageService languageService,
                       UserService userService, WordMapper wordMapper,
                       CurrentUser currentUser) {

        this.wordRepository = wordRepository;
        this.languageService = languageService;
        this.userService = userService;
        this.wordMapper = wordMapper;
        this.currentUser = currentUser;
    }

    public boolean addWordToDictionary(AddWordDTO addWordDTO) {

        final Word word = this.wordMapper.addWordDtoToWord(addWordDTO);

        final Language language = this.languageService.findLanguage(addWordDTO.getLanguage());

        final User addedBy = this.userService
                .findByUsername(this.currentUser.getUsername());

        word.setLanguage(language);
        word.setAddedBy(addedBy);

        final Word savedWord = this.wordRepository.save(word);

        final Optional<Word> wordById = this.wordRepository.findById(savedWord.getId());

        return wordById
                .isPresent();
    }

    public int findAllWordsCount() {

        return this.wordRepository
                .findAll()
                .size();
    }

    public void removeWord(Long id) {

        this.wordRepository.deleteById(id);
    }

    public void removeAllWords() {

        this.wordRepository.deleteAll();
    }
}
