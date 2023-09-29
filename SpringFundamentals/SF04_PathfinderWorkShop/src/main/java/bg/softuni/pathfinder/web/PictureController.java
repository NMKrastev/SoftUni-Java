package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.pictureDTO.PictureUploadDTO;
import bg.softuni.pathfinder.service.PictureService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @ModelAttribute("pictureUploadDTO")
    public void initUserRegistrationModel(Model model) {

        model.addAttribute("pictureUploadDTO", new PictureUploadDTO());
    }

    @PostMapping("/routes/details/{id}")
    public ModelAndView uploadPicture(ModelAndView modelAndView,
                                      @Valid PictureUploadDTO pictureUploadDTO,
                                      @PathVariable("id") String id,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("pictureUploadDTO", pictureUploadDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.pictureUploadDTO", bindingResult);

            modelAndView.setViewName(String.format("redirect:/routes/details/%s", id));
        }

        final Long routeId = Long.valueOf(id);

        this.pictureService.uploadPicture(pictureUploadDTO, routeId);

        modelAndView.setViewName(String.format("redirect:/routes/details/%s", id));

        return modelAndView;
    }
}
