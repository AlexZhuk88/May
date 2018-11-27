package mvc.temp;

import model.Concert;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ConcertRepo.ConcertRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/concert")
public class ConcertViewServlet extends HttpServlet {

    @Autowired
    private ConcertRepository concertRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());

        Integer pagin = req.getParameter("pagin") == null ? 5 : Integer.valueOf(req.getParameter("pagin"));
        Integer numPage = req.getParameter("numPage") == null ? 1 : Integer.valueOf(req.getParameter("numPage"));

        String place = req.getParameter("place") == null ? "Все места" : req.getParameter("place");
        String city = req.getParameter("city") == null ? "Все города" : req.getParameter("city");
        String groop = req.getParameter("groop") == null ? "Все группы" : req.getParameter("groop");

        List<String> listPlace = concertRepository.findAllPlace();
        listPlace.add("Все места");
        List<String> listCity = concertRepository.findAllCity();
        listCity.add("Все города");
        List<String> listGroop = concertRepository.findAllGroop();
        listGroop.add("Все группы");

        List<Concert> listConcert = concertRepository.findByFilters(pagin, numPage, place, city, groop);
        Long countConcert = concertRepository.findCountPage(pagin, numPage, place, city, groop);
        Double countPage = Math.ceil((double) countConcert / pagin);

        req.setAttribute("place", place);
        req.setAttribute("city", city);
        req.setAttribute("groop", groop);

        req.setAttribute("pagin", pagin);
        req.setAttribute("numPage", numPage);
        req.setAttribute("countPage", countPage);

        req.setAttribute("concerts", listConcert);

        req.setAttribute("places", listPlace);
        req.setAttribute("cities", listCity);
        req.setAttribute("groops", listGroop);

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/concert.jsp").forward(req, resp);
    }
}
