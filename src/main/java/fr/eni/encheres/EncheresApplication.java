package fr.eni.encheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fr.eni.encheres"})
public class EncheresApplication {

    public static void main(String[] args) {
        SpringApplication.run(EncheresApplication.class, args);
    }

}