package com.example.estafeta.courier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class CourierConfig {

    @Bean
    CommandLineRunner commandLineRunner(CourierRepository repository){
        return args -> {
            Courier Marta = new Courier("Marta", LocalDate.of(1999, Month.NOVEMBER, 25),"martasferreira@ua.pt");
            Courier Alex = new Courier("Alex", LocalDate.of(1999, Month.JANUARY, 13),"alex@ua.pt");

            repository.saveAll(
                    List.of(Marta, Alex)
            );


        };
    }
}
