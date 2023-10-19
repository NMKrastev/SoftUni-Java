package bg.softuni.temp.web;

import bg.softuni.temp.model.dto.SongDTO;
import bg.softuni.temp.serevice.SongService;
import bg.softuni.temp.serevice.UserService;
import bg.softuni.temp.utils.DurationConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static bg.softuni.temp.constant.StyleName.*;

@Controller
public class HomeController {

    private final SongService songService;
    private final UserService userService;

    public HomeController(SongService songService, UserService userService) {

        this.songService = songService;
        this.userService = userService;
    }

    @ModelAttribute("durationConverter")
    public void initDurationConverterModel(Model model) {
        model.addAttribute("durationConverter", new DurationConverter());
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<SongDTO> allPopSongs = this.songService.findAllSongs(POP);

        modelAndView.addObject("allPopSongs", allPopSongs);

        final List<SongDTO> allRockSongs = this.songService.findAllSongs(ROCK);

        modelAndView.addObject("allRockSongs", allRockSongs);

        final List<SongDTO> allJazzSongs = this.songService.findAllSongs(JAZZ);

        modelAndView.addObject("allJazzSongs", allJazzSongs);

        final List<SongDTO> userPlaylist = this.userService.findUserPlaylist();

        modelAndView.addObject("totalPlaylistDuration", userPlaylist.stream().mapToInt(SongDTO::getDuration).sum());
        modelAndView.addObject("userPlaylist", userPlaylist);

        modelAndView.setViewName("home");

        return modelAndView;
    }
}
