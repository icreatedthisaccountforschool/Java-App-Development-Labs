package com.cpan228.distributioncentre.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.stereotype.*;

import com.cpan228.distributioncentre.models.DistributionCentre;
import com.cpan228.distributioncentre.models.Item;
import com.cpan228.distributioncentre.services.DistributionCentreService;

@RestController
@RequestMapping("/api/distributionCentres")
public class DistributionCentreController {
    
    @Autowired
    private DistributionCentreService distributionCentreService;

    @GetMapping("")
    public List<DistributionCentre> getAllDistributionCentres() {
        return distributionCentreService.getAllDistributionCentres();
    }

    @GetMapping("/{id}")
    public DistributionCentre getDistributionCentreById(@PathVariable Long id) {
        return distributionCentreService.getDistributionCentreById(id);
    }

    @PostMapping("")
    public DistributionCentre createDistributionCentre(@RequestBody DistributionCentre distributionCentre) {
        return distributionCentreService.createDistributionCentre(distributionCentre);
    }

    @PutMapping("/{id}")
    public DistributionCentre updateDistributionCentre(@PathVariable Long id, @RequestBody DistributionCentre distributionCentre) {
        DistributionCentre existingDistributionCentre = distributionCentreService.getDistributionCentreById(id);
        existingDistributionCentre.setName(distributionCentre.getName());
        existingDistributionCentre.setItemsAvailable(distributionCentre.getItemsAvailable());
        existingDistributionCentre.setLatitude(distributionCentre.getLatitude());
        existingDistributionCentre.setLongitude(distributionCentre.getLongitude());
        return distributionCentreService.updateDistributionCentre(existingDistributionCentre);
    }

    @DeleteMapping("/{id}")
    public void deleteDistributionCentre(@PathVariable Long id) {
        distributionCentreService.deleteDistributionCentre(id);
    }
    
    @PostMapping("/{id}/items")
    public ResponseEntity<DistributionCentre> addItemToDistributionCentre(@PathVariable Long id, @RequestBody Item item) {
        DistributionCentre distributionCentre = distributionCentreService.addItemToDistributionCentre(id, item);
        return ResponseEntity.ok(distributionCentre);
    }
    
    @DeleteMapping("/{id}/items/{itemId}")
    public ResponseEntity<Void> deleteItemFromDistributionCentre(@PathVariable Long id, @PathVariable Long itemId) {
        distributionCentreService.deleteItemFromDistributionCentre(id, itemId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/requestItem")
    public ResponseEntity<List<Item>> requestItemByBrandAndName(@RequestParam String brand, @RequestParam String name) {
        List<Item> items = distributionCentreService.requestItemByBrandAndName(brand, name);
        return ResponseEntity.ok(items);
    }
}


