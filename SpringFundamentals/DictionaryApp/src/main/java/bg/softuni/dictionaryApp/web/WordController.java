package bg.softuni.dictionaryApp.web;

import bg.softuni.dictionaryApp.model.dto.AddWordDTO;
import bg.softuni.dictionaryApp.model.entity.enums.LanguageEnum;
import bg.softuni.dictionaryApp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {

        this.wordService = wordService;
    }

    @ModelAttribute("languages")
    public LanguageEnum[] languages() {

        return LanguageEnum.values();
    }

    @ModelAttribute("addWordDTO")
    public void initAddWordDTOModel(Model model) {

        model.addAttribute("addWordDTO", new AddWordDTO());
    }

    @GetMapping("/add")
    public ModelAndView addWord(ModelAndView modelAndView) {

        modelAndView.setViewName("word-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addWord(ModelAndView modelAndView,
                                @Valid AddWordDTO addWordDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addWordDTO", addWordDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addWordDTO", bindingResult);

            modelAndView.setViewName("redirect:/words/add");

            return modelAndView;

        }

        boolean isWordCreated = this.wordService.addWordToDictionary(addWordDTO);

        if (isWordCreated) {

            modelAndView.setViewName("redirect:/home");

        } else {

            modelAndView.setViewName("redirect:/words/add");

        }

        return modelAndView;
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeWord(ModelAndView modelAndView,
                                   @PathVariable("id") Long id) {

        this.wordService.removeWord(id);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/remove-all")
    public ModelAndView removeAllWords(ModelAndView modelAndView) {

        this.wordService.removeAllWords();

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}
