package com.example.TestHelllo.contlolers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PIController {
    @GetMapping("/Pi")
    String Output(Model model) {
        int number = 8;
        String Pi = String.format("%." + 8 + "f",Math.PI);
        model.addAttribute("pi",Pi);
        return "PI";
    }

}
