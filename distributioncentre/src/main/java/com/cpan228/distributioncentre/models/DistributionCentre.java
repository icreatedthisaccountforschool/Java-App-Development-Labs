package com.cpan228.distributioncentre.models;

import java.util.List;
//import com.cpan228.distributioncentre.models.Item;

public class DistributionCentre {
    private Long id;
    private String name;
    private List<Item> itemsAvailable;
    private Double latitude;
    private Double longitude;

    public DistributionCentre(Long id, String name, List<Item> itemsAvailable, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.itemsAvailable = itemsAvailable;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DistributionCentre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemsAvailable() {
        return itemsAvailable;
    }

    public void setItemsAvailable(List<Item> itemsAvailable) {
        this.itemsAvailable = itemsAvailable;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
