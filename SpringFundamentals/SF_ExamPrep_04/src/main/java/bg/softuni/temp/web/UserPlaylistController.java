package bg.softuni.temp.web;

import bg.softuni.temp.serevice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users/songs/")
public class UserPlaylistController {

    private final UserService userService;

    public UserPlaylistController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/add/{songId}")
    public ModelAndView addSongToPlaylist(ModelAndView modelAndView,
                                          @PathVariable("songId") Long songId) {

        boolean isAdded = this.userService.addSongToPlaylist(songId);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/remove-all")
    public ModelAndView removeAllSongsFromPlaylist(ModelAndView modelAndView) {

        this.userService.removeAllSongsFromPlaylist();

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}
