package com.cpan228.assignment1.clotheswarehousecontrol.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClothingSearchByDateDto {
    private String name;
    private String startDate;
    private String endDate;
}
