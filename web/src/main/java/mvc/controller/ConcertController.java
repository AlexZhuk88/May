package mvc.controller;

import dto.ConcertDtoFullInfo;
import dto.ConcertFilterDto;
import lombok.RequiredArgsConstructor;
import model.Concert;
import model.ConcertPlace;
import model.Groop;
import model.Timing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ConcertPlaceService;
import service.ConcertService;
import service.GroopService;
import util.DateFormater;

import java.util.List;
import java.util.Optional;

@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConcertController {

    private final ConcertService concertService;
    private final GroopService groopService;
    private final ConcertPlaceService concertPlaceService;

    @ModelAttribute("allGroop")
    public List<String> getGroop() {
        return concertService.findAllGroop();
    }

    @GetMapping("/concertview")
    public String greeting(Model model, @RequestParam(value = "pagin", required = false) String paginIn,
                           @RequestParam(value = "numPage", required = false) String numPageIn,
                           @RequestParam(value = "place", required = false) String placeIn,
                           @RequestParam(value = "city", required = false) String cityIn,
                           @RequestParam(value = "groop", required = false) String groopIn
    ) {

        Integer pagin = paginIn == null ? 5 : Integer.valueOf(paginIn);
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
    public String getconcertManager(Model model) {
        model.addAttribute("savedConcert", new ConcertDtoFullInfo());
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

    @GetMapping("/concertdetail")
    public String getConcertDetail(Model model, @RequestParam(value = "concertId") String concertId) {
        Optional<Concert> concert = concertService.findById(Long.valueOf(concertId));
        model.addAttribute("concert", concert.get());
        return "concertdetail";
    }
}



