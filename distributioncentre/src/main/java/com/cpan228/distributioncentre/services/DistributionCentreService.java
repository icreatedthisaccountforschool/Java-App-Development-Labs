package com.cpan228.distributioncentre.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cpan228.distributioncentre.models.DistributionCentre;
import com.cpan228.distributioncentre.models.Item;
import com.cpan228.distributioncentre.models.ResourceNotFoundException;
import com.cpan228.distributioncentre.repositories.DistributionCentreRepository;

@Service
public class DistributionCentreService {
    @Autowired
    private DistributionCentreRepository distributionCentreRepository;

    public List<DistributionCentre> getAllDistributionCentres() {
        return distributionCentreRepository.findAll();
    }

    public DistributionCentre getDistributionCentreById(Long id) {
        return distributionCentreRepository.findById(id).orElse(null);
    }

    public DistributionCentre createDistributionCentre(DistributionCentre distributionCentre) {
        return distributionCentreRepository.save(distributionCentre);
    }

    public DistributionCentre updateDistributionCentre(DistributionCentre distributionCentre) {
        return distributionCentreRepository.save(distributionCentre);
    }

    public void deleteDistributionCentre(Long id) {
        distributionCentreRepository.deleteById(id);
    }

    public DistributionCentre addItemToDistributionCentre(Long distributionCentreId, Item item) {
        DistributionCentre distributionCentre = distributionCentreRepository.findById(distributionCentreId).orElseThrow(() -> new ResourceNotFoundException("Distribution Centre", "id", distributionCentreId));
        List<Item> items = distributionCentre.getItemsAvailable();
        items.add(item);
        distributionCentre.setItemsAvailable(items);
        return distributionCentreRepository.save(distributionCentre);
    }

    public void deleteItemFromDistributionCentre(Long distributionCentreId, Long itemId) {
        DistributionCentre distributionCentre = distributionCentreRepository.findById(distributionCentreId).orElseThrow(() -> new ResourceNotFoundException("Distribution Centre", "id", distributionCentreId));
        List<Item> items = distributionCentre.getItemsAvailable();
        items.removeIf(item -> item.getId().equals(itemId));
        distributionCentre.setItemsAvailable(items);
        distributionCentreRepository.save(distributionCentre);
    }

    public List<Item> requestItemByBrandAndName(String brand, String name) {
        List<DistributionCentre> distributionCentres = distributionCentreRepository.findByItemBrandAndItemName(brand, name);
        List<Item> items = new ArrayList<>();
        for (DistributionCentre distributionCentre : distributionCentres) {
            List<Item> itemsAvailable = distributionCentre.getItemsAvailable();
            for (Item item : itemsAvailable) {
                if (item.getBrand().equals(brand) && item.getName().equals(name)) {
                    items.add(item);
                }
            }
        }
        return items;
    }
}
