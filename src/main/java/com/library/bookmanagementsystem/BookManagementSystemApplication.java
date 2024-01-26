package com.library.bookmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class BookManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManagementSystemApplication.class, args);
    }
}
