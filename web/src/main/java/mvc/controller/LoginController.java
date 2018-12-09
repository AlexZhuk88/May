package mvc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@Transactional
public class LoginController {

//    @ModelAttribute("user")
//    public UserDetails getCurrentUser() {
//        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        model.addAttribute("user", userDetails);
//    }

    @GetMapping("/login")
    public String getPage() {
        return "login";
    }
}
