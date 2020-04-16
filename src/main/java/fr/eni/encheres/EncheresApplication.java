package fr.eni.encheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"fr.eni.encheres"})
@EntityScan("fr.eni.encheres")
public class EncheresApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncheresApplication.class, args);
    }

}