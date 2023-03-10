package com.cpan228.assignment1.clotheswarehousecontrol.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clothing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;
    @DecimalMin(value = "1000.00", inclusive= true)
    @DecimalMax(value = "99999.99", inclusive = true)
    private BigDecimal price;
    private Brand brandFrom;
    @Min(2021)
    @Max(2121)
    @Builder.Default
    private LocalDate createdAt = LocalDate.now();

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
