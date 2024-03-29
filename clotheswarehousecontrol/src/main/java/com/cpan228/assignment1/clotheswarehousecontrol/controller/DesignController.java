package com.cpan228.assignment1.clotheswarehousecontrol.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing;
import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing.Brand;
import com.cpan228.assignment1.clotheswarehousecontrol.model.User;
import com.cpan228.assignment1.clotheswarehousecontrol.repository.ClothingRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {
    @Autowired
    private ClothingRepository clothingRepository;
    @GetMapping
    public String design(){
        return "design";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted to string: {}", brands);
    }

    @ModelAttribute
    public Clothing clothing() {
        return Clothing
                .builder()
                .build();
    }

    @PostMapping("/addClothing")
    @PreAuthorize("hasRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public String processClothingAddition(@Valid Clothing clothing,
        BindingResult result) {
        if (result.hasErrors()){
            return "design";
    }
        log.info("Processing clothing: {}, clothing");
        clothingRepository.save(clothing);
        return "redirect:/clothingList";
        }

        @PostMapping("/deleteAllFighters")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public String processClothingDeletion(@AuthenticationPrincipal User user) {
            log.info("Deleting all clothing for user: {}", user.getAuthorities());
            clothingRepository.deleteAll();
            return "redirect:/design";
            }
        
}
