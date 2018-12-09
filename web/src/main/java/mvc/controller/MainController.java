package mvc.controller;

import dto.CommentDto;
import dto.ConcertDtoFullInfo;
import dto.ConcertFilterDto;
import lombok.RequiredArgsConstructor;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;
import util.DateFormater;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    private final ConcertService concertService;
    private final TheNewService theNewService;
    private final ConcertPlaceService concertPlaceService;
    private final CommentService commentService;
    private final UserProService userService;

    @ModelAttribute("user")
    public UserDetails getCurrentUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", userDetails);
    }

    @GetMapping("/main")
    public String getMain(Model model) {
        Long countConcert = concertService.findCountConcert();
        Long countConcertComment = concertService.findCountConcertComment();
        Long countNew = theNewService.findCountNews();
        Long countNewsComment = theNewService.findCountNewsComment();
        model.addAttribute("countConcert", countConcert);
        model.addAttribute("countNew", countNew);
        model.addAttribute("countConcertComment", countConcertComment);
        model.addAttribute("countNewsComment", countNewsComment);
        return "main";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        return "contact";
    }
}



