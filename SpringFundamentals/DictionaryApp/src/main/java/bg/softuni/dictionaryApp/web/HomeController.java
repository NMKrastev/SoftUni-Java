package bg.softuni.dictionaryApp.web;

import bg.softuni.dictionaryApp.model.dto.WordDTO;
import bg.softuni.dictionaryApp.service.LanguageService;
import bg.softuni.dictionaryApp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static bg.softuni.dictionaryApp.constant.Words.*;


@Controller
public class HomeController {

    private final WordService wordService;
    private final LanguageService languageService;

    public HomeController(WordService wordService, LanguageService languageService) {

        this.wordService = wordService;
        this.languageService = languageService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<WordDTO> allGermanWords = this.languageService.findAllWordsByLanguage(GERMAN);
        modelAndView.addObject("allGermanWords", allGermanWords);

        final List<WordDTO> allSpanishWords = this.languageService.findAllWordsByLanguage(SPANISH);
        modelAndView.addObject("allSpanishWords", allSpanishWords);

        final List<WordDTO> allFrenchWords = this.languageService.findAllWordsByLanguage(FRENCH);
        modelAndView.addObject("allFrenchWords", allFrenchWords);

        final List<WordDTO> allItalianWords = this.languageService.findAllWordsByLanguage(ITALIAN);
        modelAndView.addObject("allItalianWords", allItalianWords);

        modelAndView.addObject("totalWordsCount", this.wordService.findAllWordsCount());

        modelAndView.setViewName("home");

        return modelAndView;
    }
}
