package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.Service.UserService;
import pl.coderslab.dto.RegistrationDto;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {


    @Autowired
    private UserService userService;

    @GetMapping
    public String register(Model model) {

        model.addAttribute("registrationDto", new RegistrationDto());
        return "registration/registrationForm";
    }

    @PostMapping
    public String postRegister(@Valid RegistrationDto registrationDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration/registrationForm";
        }

        boolean passwordEquals = registrationDto.getPassword().equals(registrationDto.getPasswordRepeat());

        if (!passwordEquals) {
            bindingResult.addError(new FieldError("registrationDto", "password", "różne hasła"));
            return "registration/registrationForm";
        }

        User user = new User();
        user.setUserName(registrationDto.getLogin());
        user.setHashedPassword(registrationDto.getPassword());
        user.setName(registrationDto.getName());
        user.setLastName(registrationDto.getLastName());

        userService.save(user);

        return "redirect:/login";

    }

}
