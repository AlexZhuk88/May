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
import org.springframework.web.bind.annotation.*;
import service.*;
import util.DateFormater;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConcertController {

    private final ConcertService concertService;
    private final GroopService groopService;
    private final ConcertPlaceService concertPlaceService;
    private final CommentService commentService;
    private final UserProService userService;

    @ModelAttribute("allGroop")
    public List<String> getGroop() {
        return concertService.findAllGroop();
    }

    @ModelAttribute("user")
    public UserDetails getCurrentUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", userDetails);
    }

    @GetMapping("/concertview")
    public String concertview(Model model, @RequestParam(value = "pagin", required = false) String paginIn,
                              @RequestParam(value = "numPage", required = false) String numPageIn,
                              @RequestParam(value = "place", required = false) String placeIn,
                              @RequestParam(value = "city", required = false) String cityIn,
                              @RequestParam(value = "groop", required = false) String groopIn
    ) {

        Integer pagin = paginIn == null ? 3 : Integer.valueOf(paginIn);
        Integer numPage = numPageIn == null ? 1 : Integer.valueOf(numPageIn);
        String place = placeIn == null ? "Все места" : placeIn;
        String city = cityIn == null ? "Все города" : cityIn;
        String groop = groopIn == null ? "Все группы" : groopIn;

        ConcertFilterDto concertFilterDto = concertService.prepareConcertPage(pagin, numPage, place, city, groop);
        Double countPage = Math.ceil((double) concertFilterDto.getCountConcert() / pagin);

        model.addAttribute("place", place);
        model.addAttribute("city", city);
        model.addAttribute("groop", groop);
        model.addAttribute("pagin", pagin);
        model.addAttribute("numPage", numPage);
        model.addAttribute("countPage", countPage);
        model.addAttribute("concerts", concertFilterDto.getListConcert());
        model.addAttribute("places", concertFilterDto.getListPlace());
        model.addAttribute("cities", concertFilterDto.getListCity());
        model.addAttribute("groops", concertFilterDto.getListGroop());

        return "concertview";
    }

    @GetMapping("/concertmanager")
    public String getconcertManager(Model model, @RequestParam(value = "pagin", required = false) String paginIn,
                                    @RequestParam(value = "numPage", required = false) String numPageIn,
                                    @RequestParam(value = "place", required = false) String placeIn,
                                    @RequestParam(value = "city", required = false) String cityIn,
                                    @RequestParam(value = "groop", required = false) String groopIn
    ) {

        Integer pagin = paginIn == null ? 3 : Integer.valueOf(paginIn);
        Integer numPage = numPageIn == null ? 1 : Integer.valueOf(numPageIn);
        String place = placeIn == null ? "Все места" : placeIn;
        String city = cityIn == null ? "Все города" : cityIn;
        String groop = groopIn == null ? "Все группы" : groopIn;

        ConcertFilterDto concertFilterDto = concertService.prepareConcertPage(pagin, numPage, place, city, groop);
        Double countPage = Math.ceil((double) concertFilterDto.getCountConcert() / pagin);

        model.addAttribute("place", place);
        model.addAttribute("city", city);
        model.addAttribute("groop", groop);
        model.addAttribute("pagin", pagin);
        model.addAttribute("numPage", numPage);
        model.addAttribute("countPage", countPage);
        model.addAttribute("concerts", concertFilterDto.getListConcert());
        model.addAttribute("places", concertFilterDto.getListPlace());
        model.addAttribute("cities", concertFilterDto.getListCity());
        model.addAttribute("groops", concertFilterDto.getListGroop());


        model.addAttribute("savedConcert", new ConcertDtoFullInfo());
        model.addAttribute("updatedConcert", new ConcertDtoFullInfo());
        return "concertmanager";
    }

    @PostMapping("/concertmanager")
    public String saveConcert(ConcertDtoFullInfo dtoConcert) {
        Groop groop = groopService.findByName(dtoConcert.getGroopname());
        Concert savedConcert = Concert.builder()
                .concertName(dtoConcert.getConcertName())
                .groop(groop)
                .timing(Timing.of(DateFormater.formatDate(dtoConcert.getDate()), DateFormater.formatTime(dtoConcert.getTime())))
                .discription(dtoConcert.getDiscription())
                .build();
        Concert concert = concertService.saveConcert(savedConcert);
        ConcertPlace concertPlace = ConcertPlace.builder()
                .concert(concert)
                .place(dtoConcert.getPlace())
                .city(dtoConcert.getCity())
                .entrance(dtoConcert.getEntrance())
                .build();
        concertPlaceService.saveConcertPlace(concertPlace);
        return "redirect:/concertmanager";
    }

    @PostMapping("/concertupdate")
    public String updateConcert(ConcertDtoFullInfo dtoConcert,@RequestParam(value = "concertId", required = false) String concertId) {
        Groop groop = groopService.findByName(dtoConcert.getGroopname());

        concertService.updateConcertPlace(Long.valueOf(concertId),dtoConcert.getCity(),dtoConcert.getPlace(),dtoConcert.getEntrance());
        concertService.updateConcert(Long.valueOf(concertId),dtoConcert.getConcertName(),dtoConcert.getDiscription(),DateFormater.formatTime(dtoConcert.getTime()),DateFormater.formatDate(dtoConcert.getDate()),groop.getId());
        return "redirect:/concertmanager";
    }

    @GetMapping("/concertdetail")
    public String getConcertDetail(Model model, @RequestParam(value = "concertId", required = false) String concertId) {
        Optional<Concert> concert = concertService.findById(Long.valueOf(concertId));
        List<ConcertComment> listComments = commentService.findAllComments(concert.get());
        model.addAttribute("concert", concert.get());
        model.addAttribute("comments", listComments);
        model.addAttribute("commentform", new CommentDto());
        return "concertdetail";
    }

    @GetMapping("/concertdelete")
    public String getConcertDelete(Model model, @RequestParam(value = "concertId", required = false) String concertId) {
        commentService.deleteCommentByConcertId(Long.valueOf(concertId));
        concertService.deleteConcert(Long.valueOf(concertId));
        return "redirect:/concertmanager";
    }

    @GetMapping("/concertupdate")
    public String getConcertUpdate(Model model, @RequestParam(value = "concertId", required = false) String concertId) {
        commentService.deleteCommentByConcertId(Long.valueOf(concertId));
        concertService.deleteConcert(Long.valueOf(concertId));
        return "redirect:/concertmanager";
    }

    @PostMapping("/concertdetail")
    public String saveComment(CommentDto commentform, @RequestParam(value = "concertId", required = false) String concertId) {
        Concert concert = concertService.findById(Long.valueOf(concertId)).get();
        User user = userService.findById(getCurrentUser().getUsername());
        ConcertComment concertComment = new ConcertComment(user, Timing.of(LocalDate.now(), LocalTime.now()), commentform.getDiscription(), concert);
        commentService.saveComment(concertComment);
        return "redirect:/concertdetail?concertId=" + concertId;
    }
}



