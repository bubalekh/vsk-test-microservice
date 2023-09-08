package ru.vsk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("ru.vsk")
public class ShopApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ShopApplication.class, args);
    }
}
