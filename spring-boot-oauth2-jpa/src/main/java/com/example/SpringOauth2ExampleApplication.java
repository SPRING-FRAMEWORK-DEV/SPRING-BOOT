package com.example;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.config.CustomUserDetails;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.repositories.UserRepository;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringOauth2ExampleApplication {

	@Autowired
	static UserRepository repo;
	// get access token
	// http://localhost:9999/oauth/token?grant_type=password&username=user&password=user
	
	// access private data using access token from above step.
	//http://localhost:9999/private?access_token=3d60d0d9-6060-4675-b840-039e7e4d0b84
	
	// get access token again by using refresh token
	// http://localhost:9999/oauth/token?grant_type=refresh_token&refresh_token=4ca2a0d3-fb95-488d-b304-cb9cd127c02c
	public static void main(String[] args) {
		SpringApplication.run(SpringOauth2ExampleApplication.class, args);
		
		if (repo.count() == 0) {
			repo.save(new User("user", "user", Arrays.asList(new Role("USER"), new Role("ADMIN"))));
		}
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		builder.userDetailsService(new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				// TODO Auto-generated method stub

				
				return new CustomUserDetails(repo.findByUsername(s));
			}
		});
	}
}
