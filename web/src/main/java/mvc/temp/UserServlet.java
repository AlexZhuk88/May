package mvc.temp;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long idUser = Long.valueOf(req.getParameter("id"));
        User user = UserService.getInstance().getUserById(idUser);
        req.setAttribute("username", user.getUsername());
        req.setAttribute("useremail", user.getEmail());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/example.jsp")
                .forward(req, resp);
    }
}