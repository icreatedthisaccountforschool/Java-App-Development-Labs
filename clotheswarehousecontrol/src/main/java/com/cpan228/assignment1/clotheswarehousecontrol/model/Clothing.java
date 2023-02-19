package com.cpan228.assignment1.clotheswarehousecontrol.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Clothing {
    @Id
    private long id;
    @NotBlank
    private String name;
    //@Min(2021)
    //@Max(2121)
    //private int year;
    @DecimalMin(value = "1000.00", inclusive= true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal price;
    private Brand brandFrom;
    @Min(2021)
    @Max(2121)
    private final Date createdAt = new Date();

    public enum Brand {
        NIKE("Nike"), ADIDAS("Adidas"), REEBOK("Reebok"), PUMA("Puma");
        
        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
