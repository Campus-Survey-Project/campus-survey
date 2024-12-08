package com.example.campus_survey_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping(value = {"/{path:[^\\.]*}", "/**/{path:^(?!.*\\..*$).*$}"})
    public String forwardToIndex() {
        return "forward:/index.html";
    }
}

