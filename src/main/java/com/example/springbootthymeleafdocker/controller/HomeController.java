package com.example.springbootthymeleafdocker.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.*;


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
        Vector<HashMap<String, String>> vec = new Vector<>(3);
        for (int i = 1; i < 4; i++) {
            HashMap<String, String> map = new HashMap<>();
            map.put("first", "Given" + i);
            map.put("last", "Surname" + i);
            map.put("email", "given.surname" + i + "@example.com");
            vec.add(map);
        }
        model.addAttribute("people", vec);
        return "bootstrap-hello";
    }

    @GetMapping({"/bootstrap", "/bootstrap/"})
    public String bootstrap(Model model) { return bootstrap(model, "World"); }
}