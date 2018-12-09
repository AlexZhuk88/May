package mvc.controller;

import dto.NewsFilterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import service.TheNewService;


import java.util.List;


@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TheNewsController {

    private final TheNewService theNewService;

    @ModelAttribute("allAuthors")
    public List<String> getAuthors() {
        return theNewService.findAllAuthors();
    }

    @ModelAttribute("user")
    public UserDetails getCurrentUser() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/newsview")
    public String greeting(Model model, @RequestParam(value = "pagin", required = false) String paginIn,
                           @RequestParam(value = "numPage", required = false) String numPageIn,
                           @RequestParam(value = "starttime", required = false) String starttimeIn,
                           @RequestParam(value = "endtime", required = false) String endtimeIn,
                           @RequestParam(value = "author", required = false) String authorIn
    ) {

        Integer pagin = paginIn == null ? 5 : Integer.valueOf(paginIn);
        Integer numPage = numPageIn == null ? 1 : Integer.valueOf(numPageIn);
        String starttime = starttimeIn == null || starttimeIn.equals("") ? "Без ограничений" : starttimeIn;
        String endtime = endtimeIn == null || endtimeIn.equals("") ? "Без ограничений" : endtimeIn;
        String author = authorIn == null ? "Все авторы" : authorIn;

        NewsFilterDto newsFilterDto = theNewService.prepareNewsPage(pagin, numPage, starttime, endtime, author);
        Double countPage = Math.ceil((double) newsFilterDto.getCountNews() / pagin);

        model.addAttribute("starttime", starttime);
        model.addAttribute("endtime", endtime);
        model.addAttribute("pagin", pagin);
        model.addAttribute("numPage", numPage);
        model.addAttribute("countPage", countPage);
        model.addAttribute("author", author);
        model.addAttribute("thenews", newsFilterDto.getListNews());
        model.addAttribute("authors", newsFilterDto.getListAuthors());

        return "newsview";
    }
}



