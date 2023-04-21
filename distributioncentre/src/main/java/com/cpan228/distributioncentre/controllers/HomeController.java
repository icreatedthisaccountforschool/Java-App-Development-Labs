package com.cpan228.distributioncentre.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("title", "Admin Page");
        return modelAndView;
    }

    @GetMapping("/distributionCentres")
    public ModelAndView distributionCentres() {
        ModelAndView mav = new ModelAndView("distributionCentres");
        return mav;
    }

    //@GetMapping("/")
    //@ResponseBody
    //public String home() {
        //return "admin";
    //}
}

