package in.prathamattri.cicddemo.controllers;

import in.prathamattri.cicddemo.entity.UserDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @PostMapping("/greeting")
    @ResponseBody
    public ResponseEntity<String> greeting(@ModelAttribute UserDetails userDetails){
        return ResponseEntity.ok(String.format("Hello %s", userDetails.getFullName()));
    }
}

