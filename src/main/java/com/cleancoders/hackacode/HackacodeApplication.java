package com.cleancoders.hackacode;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class HackacodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackacodeApplication.class, args);
	}
	@Bean
	public CommandLineRunner generateEncryptedPassword(BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			String plainPassword = "password";
			String encryptedPassword = passwordEncoder.encode(plainPassword);
			System.out.println("Encrypted Password: " + encryptedPassword);
			System.out.println("Decripted:" + passwordEncoder.matches("password", "$2a$10$XZOgHPmwGlAolyjgMZsJ8.ghF8vc4nrXoBcFrk7vsKcwDDtr7xlVK"));
		};
	}

}
