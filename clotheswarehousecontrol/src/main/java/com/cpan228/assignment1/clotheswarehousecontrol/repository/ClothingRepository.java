package com.cpan228.assignment1.clotheswarehousecontrol.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing;
import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing.Brand;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {
    List<Clothing> findByBrandFrom(Brand brand);
    
    List<Clothing> findByNameStartsWithAndCreatedAtBetween(String name, LocalDate startDate,
LocalDate endDate);
}
