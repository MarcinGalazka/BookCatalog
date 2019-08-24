package pl.marcingalazka.bookcatalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("hello")
    public ModelAndView updateHello(){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("name","Marcin");
        modelAndView.addObject("wiek",100);
        return modelAndView;

    }
}
