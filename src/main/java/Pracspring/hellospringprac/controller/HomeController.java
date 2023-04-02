package Pracspring.hellospringprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //localhost 8080으로 들어오면 기본으로 호출되는 웹
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
