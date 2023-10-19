package bg.softuni.temp.web;

import bg.softuni.temp.model.dto.AddSongDTO;
import bg.softuni.temp.model.entity.enums.StyleEnum;
import bg.softuni.temp.serevice.SongService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {

        this.songService = songService;
    }

    @ModelAttribute("styles")
    public StyleEnum[] styles() {
        return StyleEnum.values();
    }

    @ModelAttribute("addSongDTO")
    public void initAddSongDTOModel(Model model) {
        model.addAttribute("addSongDTO", new AddSongDTO());
    }

    @GetMapping("/add")
    public ModelAndView addSong(ModelAndView modelAndView) {

        modelAndView.setViewName("song-add");

        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addSong(ModelAndView modelAndView,
                                @Valid AddSongDTO addSongDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("addSongDTO", addSongDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addSongDTO", bindingResult);

            modelAndView.setViewName("redirect:/songs/add");

            return modelAndView;

        }

        boolean isSongCreated = this.songService.createSong(addSongDTO);

        if (isSongCreated) {

            modelAndView.setViewName("redirect:/home");

        } else {

            modelAndView.setViewName("redirect:/songs/add");

        }

        return modelAndView;
    }


}
