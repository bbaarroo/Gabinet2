package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.Service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(path = "/app")
public class HomeController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "home";
    }

}
