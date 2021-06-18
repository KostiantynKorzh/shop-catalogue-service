package me.study.catalogue_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogueServiceApplication {

    public static void main(String[] args) {

        System.out.println("Test");
        System.out.println(System.getenv("DB_URL"));

        SpringApplication.run(CatalogueServiceApplication.class, args);
    }

}
