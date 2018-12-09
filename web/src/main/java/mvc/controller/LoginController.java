package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Transactional
public class LoginController {

    @GetMapping("/login")
    public String getPage() {
        return "login";
    }
}
