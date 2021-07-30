package com.example.springbootthymeleafdocker.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping({ "/", "/hello" })
public class HomeController {

    @GetMapping("{name}")
    public String hello(Model model, @PathVariable("name") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("")
    public String hello(Model model) {
        return hello(model, "World");
    }
    
    @GetMapping("/bootstrap/{name}")
    public String bootstrap(Model model, @PathVariable(required = false) String name){
        model.addAttribute("name", name);
        return "bootstrap-hello";
    }

    @GetMapping({"/bootstrap", "/bootstrap/"})
    public String bootstrap(Model model) { return bootstrap(model, "World"); }
}

