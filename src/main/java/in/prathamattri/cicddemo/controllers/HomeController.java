package in.prathamattri.cicddemo.controllers;

import in.prathamattri.cicddemo.entity.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @PostMapping("/greeting")
    public String greeting( @ModelAttribute UserDetails userDetails, Model model) {

        model.addAttribute("name", userDetails.getFullName());
        return "greeting";
    }
}


