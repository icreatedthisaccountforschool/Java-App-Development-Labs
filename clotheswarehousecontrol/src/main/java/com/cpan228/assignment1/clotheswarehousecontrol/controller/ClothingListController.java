package com.cpan228.assignment1.clotheswarehousecontrol.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpan228.assignment1.clotheswarehousecontrol.model.dto.ClothingSearchByDateDto;
import com.cpan228.assignment1.clotheswarehousecontrol.repository.ClothingRepository;

@Controller
@RequestMapping
public class ClothingListController {
    private ClothingRepository clothingRepository;

    public ClothingListController(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    @GetMapping
    public String showClothing(Model model) {
        return "clothinglist";
    }

    @ModelAttribute
    public void clothing(Model model) {
        model.addAttribute("clothing", clothingRepository.findAll());
    }

    @ModelAttribute
    public void clothingByDateDto(Model model) {
        model.addAttribute("clothingByDateDto", new ClothingSearchByDateDto());
    }

    @PostMapping
    public String searchClothingByDate(@ModelAttribute ClothingSearchByDateDto
clothingByDateDto,
            Model model) {
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        model.addAttribute("clothing", 
clothingRepository.findByNameStartsWithAndCreatedAtBetween(
                clothingByDateDto.getName(), LocalDate.parse(clothingByDateDto.getStartDate(),
dateFormatter),
                LocalDate.parse(clothingByDateDto.getEndDate(), dateFormatter)));
        return "clothinglist";
    }
}
