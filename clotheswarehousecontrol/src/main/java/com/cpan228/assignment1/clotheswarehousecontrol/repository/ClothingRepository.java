package com.cpan228.assignment1.clotheswarehousecontrol.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {
    
}
