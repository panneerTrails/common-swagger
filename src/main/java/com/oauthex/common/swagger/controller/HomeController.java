package com.oauthex.common.swagger.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class HomeController {

    @RequestMapping("/")
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
