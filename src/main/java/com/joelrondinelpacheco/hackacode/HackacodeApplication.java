package com.joelrondinelpacheco.hackacode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class HackacodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackacodeApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner createPasswordCommand(){
		return args -> {
			System.out.println(passwordEncoder.encode("password1234"));
			System.out.println(passwordEncoder.encode("password1234"));
			System.out.println(passwordEncoder.encode("password1234"));
			System.out.println(passwordEncoder.encode("password1234"));
			System.out.println(UUID.randomUUID().toString());
		};
	}

}
