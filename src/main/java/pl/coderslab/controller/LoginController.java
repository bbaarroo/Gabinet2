package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.LoginDto;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String login(Model model) {

        model.addAttribute("loginDto", new LoginDto());
        return "login/LoginForm";
    }


    @PostMapping
    public String postLogin(HttpServletRequest request, @Valid LoginDto loginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        User user = userRepository.findByUserName(loginDto.getLogin());

        if (user == null) {
            return "login/LoginError";
        }

        String userPassword = user.getPassword();

        boolean checkpw = BCrypt.checkpw(loginDto.getPassword(), userPassword);

        if (checkpw) {

            request.getSession(true).setAttribute("loggedIn", true);
            request.getSession().setAttribute("user", user);

            return "redirect:/app/home";

        } else {
            return "login/LoginError";
        }

    }


}
