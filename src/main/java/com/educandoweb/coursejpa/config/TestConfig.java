package com.educandoweb.coursejpa.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.coursejpa.entities.User;
import com.educandoweb.coursejpa.repositories.UserRepository;

//********************** TEST classe auxiliar para configs na app
//********************** TestConfig Serve para popular o bd com objs
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner //CommandLineRunner void run - executa a classe quando app e iniciada
{
	@Autowired //Dependencia associando a instancia de userRepository
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception
	{
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));//.saveAll - Passa uma lista e salva no bd
	}
}
