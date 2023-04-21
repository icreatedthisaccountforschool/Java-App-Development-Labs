package com.cpan228.distributioncentre.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.cpan228.distributioncentre.models.DistributionCentre;
import com.cpan228.distributioncentre.services.DistributionCentreService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DistributionCentreService distributionCentreService;

    @GetMapping("/distributionCentres")
    public ModelAndView displayDistributionCentres() {
        ModelAndView modelAndView = new ModelAndView("distributionCentres");
        List<DistributionCentre> distributionCentres = distributionCentreService.getAllDistributionCentres();
        modelAndView.addObject("distributionCentres", distributionCentres);
        return modelAndView;
    }
}

