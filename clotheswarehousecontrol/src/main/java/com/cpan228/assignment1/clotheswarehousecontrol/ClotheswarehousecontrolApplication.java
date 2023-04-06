package com.cpan228.assignment1.clotheswarehousecontrol;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing;
import com.cpan228.assignment1.clotheswarehousecontrol.model.Clothing.Brand;
import com.cpan228.assignment1.clotheswarehousecontrol.repository.ClothingRepository;

@SpringBootApplication
public class ClotheswarehousecontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClotheswarehousecontrolApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ClothingRepository repository) {
		return args -> {
			repository.save(Clothing.builder()
							.name("Athletic Sweater")
							.brandFrom(Brand.ADIDAS)
							//.createdAt(new LocalDate(2021,1,1))
							.price(new BigDecimal(1000)).build());

			repository.save(Clothing.builder()
							.name("Basketball Sneakers")
							.brandFrom(Brand.NIKE)
							//.createdAt(new LocalDate(2021,1,1))
							.price(new BigDecimal(1000)).build());

			repository.save(Clothing.builder()
							.name("Set of Socks")
							.brandFrom(Brand.PUMA)
							//.createdAt(new LocalDate(2021,1,1))
							.price(new BigDecimal(1000)).build());

			repository.save(Clothing.builder()
							.name("Jogging Pants")
							.brandFrom(Brand.REEBOK)
							//.createdAt(new LocalDate(2021,1,1))
							.price(new BigDecimal(1000)).build());
		};
	}

}
