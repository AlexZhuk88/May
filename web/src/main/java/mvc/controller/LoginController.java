package mvc.controller;

import dto.UserDto;
import lombok.RequiredArgsConstructor;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserProService;


@Controller
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final UserProService userService;


    @GetMapping("/login")
    public String getPage(Model model) {
        model.addAttribute("dto", new UserDto());
        return "login";
    }

    @PostMapping("/saveus")
    public String saveConcert(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .role(Role.USER)
                .build();
        userService.saveUser(user);
        return "redirect:/login";
    }
}
