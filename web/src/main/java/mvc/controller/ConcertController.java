package mvc.controller;

import dto.ConcertFilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.ConcertService;

@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConcertController {

    private final ConcertService concertService;

    @GetMapping("/kt3")
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

        return "concert";
    }
}
