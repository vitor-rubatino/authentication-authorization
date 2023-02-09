package com.rubatino.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Tcc1AuthenticationAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tcc1AuthenticationAuthorizationApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("senha123"));
    }

}
