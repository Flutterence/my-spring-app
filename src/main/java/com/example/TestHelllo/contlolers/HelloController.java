package com.example.TestHelllo.contlolers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloController {
    @GetMapping("/greeting")
    public String Greetings(@RequestParam(name="name",required = false,defaultValue = "World")String Name,Model model){
        model.addAttribute("name",Name);
        return "greeting";
    }
}
